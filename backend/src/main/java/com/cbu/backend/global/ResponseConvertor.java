package com.cbu.backend.global;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponseConvertor {

    public <T> ResponseEntity<ResponseFormat<T>> to(ResponseFormat<T> responseFormat) {
        ResponseEntity.BodyBuilder responseEntityBuilder =
                ResponseEntity.status(responseFormat.getCode());
        Optional.ofNullable(responseFormat.getResult())
                .ifPresent(responseEntityBuilder::body);

        return responseEntityBuilder.build();
    }

}
