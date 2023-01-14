package com.cbu.backend.externalbookfinder.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookFinderRequest {
    @NotBlank
    private String keyword;
    @Range(min = 1, max = 1000)
    private Integer page;
    @Range(min = 1, max = 500)
    private Integer pageSize;

}
