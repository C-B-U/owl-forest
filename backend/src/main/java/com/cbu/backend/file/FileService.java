package com.cbu.backend.file;

import com.cbu.backend.file.dto.FileDownloadResponse;
import com.cbu.backend.file.dto.FileUploadResponse;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileUploadResponse upload(MultipartFile file);
    FileDownloadResponse download(Long id);
}
