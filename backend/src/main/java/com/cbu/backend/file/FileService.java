package com.cbu.backend.file;

import com.cbu.backend.file.dto.UploadFileResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    UploadFileResponse upload(MultipartFile file);
    Resource download(String filename);
}
