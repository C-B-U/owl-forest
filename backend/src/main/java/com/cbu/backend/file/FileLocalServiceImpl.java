package com.cbu.backend.file;

import com.cbu.backend.config.storage.LocalStorageProperties;
import com.cbu.backend.file.dto.FileDownloadResponse;
import com.cbu.backend.file.dto.FileUploadResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileLocalServiceImpl implements FileService {
    private final Path fileStorageLocation;
    private final FileRepository fileRepository;
    private final FileMapper fileMapper;

    @Autowired
    public FileLocalServiceImpl(LocalStorageProperties localStorageProperties, FileRepository fileRepository, FileMapper fileMapper) {
        this.fileMapper = fileMapper;
        this.fileRepository = fileRepository;
        this.fileStorageLocation =
                Paths.get(localStorageProperties.getLocation()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException();
        }
    }

    @Override
    @Transactional
    public FileUploadResponse upload(MultipartFile file) {
        String fileName = storeFile(file);
        try {
            String fileDownloadUri =
                    ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/files/")
                            .toUriString();

            File saveFile =
                    fileRepository.save(
                    new File(fileName,
                            fileDownloadUri,
                            file.getContentType(),
                            file.getSize(),
                            StorageType.LOCAL));
            saveFile.updateUri();

            return fileMapper.toFileUploadResponse(saveFile);
        } catch (Exception ex) {
            throw new FileStorageException();
        }
    }

    @Override
    public FileDownloadResponse download(Long id) {
        byte[] data;
        File file = fileRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        try {
            Path path =
                    Paths.get(this.fileStorageLocation.resolve(file.getFilename()).normalize().toString());
            data = Files.readAllBytes(path);
        } catch (IOException ex) {
            throw new FileStorageException();
        }
        return new FileDownloadResponse(new ByteArrayResource(data), file.getFilename());
    }

    private String storeFile(MultipartFile file) {
        String[] splitFilename = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        String fileType = splitFilename[splitFilename.length - 1];
        String fileName = UUID.randomUUID() + "." + fileType;

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException();
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);
            inputStream.close();

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException();
        }
    }
}
