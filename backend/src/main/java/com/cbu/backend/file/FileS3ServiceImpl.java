package com.cbu.backend.file;

import com.cbu.backend.file.dto.UploadFileResponse;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileS3ServiceImpl implements FileService {
    @Override
    public UploadFileResponse upload(MultipartFile file) {
        return null;
    }

    @Override
    public Resource download(String filename) {
        return null;
    }
}
