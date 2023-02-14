package com.cbu.backend.file;

import com.cbu.backend.file.dto.FileDownloadResponse;
import com.cbu.backend.file.dto.FileUploadResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
@RequestMapping("files")
public class FileController {
    private final FileService fileService;

    @PostMapping
    public ResponseEntity<FileUploadResponse> uploadFile(MultipartFile file) {
        return ResponseEntity.ok(fileService.upload(file));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        FileDownloadResponse fileDownloadResponse = fileService.download(id);

        return ResponseEntity.ok()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename(fileDownloadResponse.getFilename(), StandardCharsets.UTF_8)
                                .build()
                                .toString())
                .body(fileDownloadResponse.getFile());
    }
}
