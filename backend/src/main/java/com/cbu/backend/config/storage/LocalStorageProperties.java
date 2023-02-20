package com.cbu.backend.config.storage;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.servlet.multipart")
public class LocalStorageProperties {
    private String location;
}
