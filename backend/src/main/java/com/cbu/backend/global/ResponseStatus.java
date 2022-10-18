package com.cbu.backend.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 박현준
 *
 * 코드 규칙:
 * 헤드 네임은 각 서비스를 명시
 * 데이터에 대한 변경(예:생성, 수정, 삭제)은 0XX
 * 데이터에 대한 조회(예: 목록 조회, 단일 조회)는 1XX
 * 이후 코드 번호는 구현순으로
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {
    //게시글 (BOARD) 응답 상태
    //Head Name : B
    POST_BOARD_SUCCESS("B000", "게시글 업로드 성공"),
    UPDATE_BOARD_SUCCESS("B001", "게시글 수정 성공"),
    DELETE_BOARD_SUCCESS("B002", "게시글 삭제 성공"),

    GET_BOARD_SUCCESS("B100", "게시글 조회 성공"),
    GET_BOARD_LIST_SUCCESS("B101", "게시글 목록 조회 성공"),
    ;

    private final String code;
    private final String message;
}
