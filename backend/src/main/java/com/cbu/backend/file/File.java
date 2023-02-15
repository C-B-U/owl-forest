package com.cbu.backend.file;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {
    @Id @GeneratedValue private Long id;
    private String filename;
    private String downloadUri;
    private String contentType;
    private Long fileSize;

    @Enumerated(EnumType.STRING)
    private StorageType storageType;

    @Builder
    public File(
            String filename,
            String downloadUri,
            String contentType,
            Long fileSize,
            StorageType storageType) {
        this.filename = filename;
        this.downloadUri = downloadUri;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.storageType = storageType;
    }

    public void updateUri() {
        if (this.downloadUri.endsWith("/")) {
            this.downloadUri += this.id;
        }
    }
}
