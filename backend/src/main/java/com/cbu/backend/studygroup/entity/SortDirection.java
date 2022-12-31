package com.cbu.backend.studygroup.entity;

import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortDirection {
  ASC(Comparator.naturalOrder()),
  DESC(Comparator.reverseOrder());

  private final Comparator<Comparable> sortClassifier;
}
