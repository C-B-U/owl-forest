package com.cbu.backend.file;

import com.cbu.backend.file.dto.FileUploadResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    FileUploadResponse toFileUploadResponse(File file);
}
