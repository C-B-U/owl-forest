package com.cbu.backend.file;

import com.cbu.backend.config.audit.AuditListener;
import com.cbu.backend.config.audit.Auditable;
import com.cbu.backend.global.BaseTime;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Where(clause = "deleted_at is null")
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
        this.baseTime = new BaseTime();
    }

    public void updateUri() {
        if (this.downloadUri.endsWith("/")) {
            this.downloadUri += this.id;
        }
    }
}
