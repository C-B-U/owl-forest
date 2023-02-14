package com.cbu.backend.file.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FileDownloadResponse {
    private Resource file;
    private String filename;
}
