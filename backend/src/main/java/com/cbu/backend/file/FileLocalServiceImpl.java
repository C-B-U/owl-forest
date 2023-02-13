package com.cbu.backend.file;

import com.cbu.backend.config.storage.LocalStorageProperties;
import com.cbu.backend.file.dto.UploadFileResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Primary
@Service
public class FileLocalServiceImpl implements FileService {
    private final Path fileStorageLocation;

    @Autowired
    public FileLocalServiceImpl(LocalStorageProperties localStorageProperties) {

        fileStorageLocation =
                Paths.get(localStorageProperties.getLocation()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException();
        }
    }

    @Override
    public UploadFileResponse upload(MultipartFile file) {
        UploadFileResponse uploadFileResponse = null;
        String fileName = storeFile(file);
        try {
            if (!fileName.isBlank()) {
                String fileDownloadUri =
                        ServletUriComponentsBuilder.fromCurrentContextPath()
                                .path("/files")
                                .queryParam("filename", fileName)
                                .toUriString();
                uploadFileResponse =
                        new UploadFileResponse(
                                fileName, fileDownloadUri, file.getContentType(), file.getSize());
            }
        } catch (Exception ex) {
            throw new FileStorageException();
        }
        return uploadFileResponse;
    }

    @Override
    public Resource download(String filename) {
        byte[] data;
        try {
            Path path =
                    Paths.get(this.fileStorageLocation.resolve(filename).normalize().toString());
            data = Files.readAllBytes(path);
        } catch (IOException ex) {
            throw new FileStorageException();
        }
        return new ByteArrayResource(data);
    }

    private String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
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
