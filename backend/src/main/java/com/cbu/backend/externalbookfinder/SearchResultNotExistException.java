package com.cbu.backend.externalbookfinder;

public class SearchResultNotExistException extends RuntimeException {
    public SearchResultNotExistException() {
        super("탐색 결과를 찾을 수 없습니다. ");
    }
}
