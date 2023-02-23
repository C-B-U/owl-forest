package com.cbu.backend.file;

import com.cbu.backend.global.audit.AuditListener;
import com.cbu.backend.global.audit.Auditable;
import com.cbu.backend.global.audit.BaseTime;
import com.cbu.backend.global.audit.SoftDeleteSupport;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@SoftDeleteSupport
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File implements Auditable {
    @Id @GeneratedValue private Long id;
    private String filename;
    private String downloadUri;
    private String contentType;
    private Long fileSize;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

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
