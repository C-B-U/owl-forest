package com.cbu.backend.file.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadResponse {
    private Long id;
    private String filename;
    private String downloadUri;
    private String contentType;
    private Long fileSize;
}
