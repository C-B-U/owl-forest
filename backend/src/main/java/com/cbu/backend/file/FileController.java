package com.cbu.backend.file;

import com.cbu.backend.file.dto.UploadFileResponse;
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
    public ResponseEntity<UploadFileResponse> uploadFile(MultipartFile file) {
        return ResponseEntity.ok(fileService.upload(file));
    }

    @GetMapping
    public ResponseEntity<Resource> downloadFile(@RequestParam String filename) {
        Resource file = fileService.download(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                        .filename(filename, StandardCharsets.UTF_8)
                        .build()
                        .toString())
                .body(file);
    }
}
