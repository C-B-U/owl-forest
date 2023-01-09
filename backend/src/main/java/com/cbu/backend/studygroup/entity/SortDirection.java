package com.cbu.backend.studygroup.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 정렬 방향을 분기해주는 ENUM
 *
 * @author ohksj(김승진)
 */
@AllArgsConstructor
@Getter
public enum SortDirection {
    ASC(Comparator.naturalOrder()),
    DESC(Comparator.reverseOrder());

    private final Comparator<Comparable> sortClassifier;
}
