package com.cbu.backend.file;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.cbu.backend.config.storage.S3StorageProperties;
import com.cbu.backend.file.dto.FileDownloadResponse;
import com.cbu.backend.file.dto.FileUploadResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

@Primary
@Service
@RequiredArgsConstructor
public class FileS3ServiceImpl implements FileService {
    private final S3StorageProperties s3StorageProperties;
    private final AmazonS3Client amazonS3Client;
    private final FileRepository fileRepository;
    private final FileMapper fileMapper;

    @Override
    @Transactional
    public FileUploadResponse upload(MultipartFile file) {
        String[] splitFilename = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        String fileType = splitFilename[splitFilename.length - 1];
        ObjectMetadata data = new ObjectMetadata();
        String fileName = UUID.randomUUID() + "." + fileType;
        data.setContentType(fileName);
        data.setContentLength(file.getSize());
        try {
            amazonS3Client.putObject(
                    new PutObjectRequest(
                                    s3StorageProperties.getBucket(),
                                    fileName,
                                    file.getInputStream(),
                                    data)
                            .withCannedAcl(CannedAccessControlList.PublicRead));
            String downloadUri =
                    ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/files/")
                            .toUriString();

            File saveFile =
                    fileRepository.save(
                            new File(
                                    fileName,
                                    downloadUri,
                                    file.getContentType(),
                                    file.getSize(),
                                    StorageType.S3));
            saveFile.updateUri();

            return fileMapper.toFileUploadResponse(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileStorageException();
        }
    }

    @Override
    public FileDownloadResponse download(Long id) {
        String filename =
                fileRepository.findById(id).orElseThrow(EntityNotFoundException::new).getFilename();

        S3Object s3Object =
                amazonS3Client.getObject(
                        new GetObjectRequest(s3StorageProperties.getBucket(), filename));
        S3ObjectInputStream objectInputStream = s3Object.getObjectContent();
        try {
            byte[] data = IOUtils.toByteArray(objectInputStream);
            return new FileDownloadResponse(new ByteArrayResource(data), filename);
        } catch (IOException e) {
            throw new FileStorageException();
        }
    }
}
