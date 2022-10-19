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
    //Head Name : BD
    POST_BOARD_SUCCESS("BD000", "게시글 업로드 성공"),
    UPDATE_BOARD_SUCCESS("BD001", "게시글 수정 성공"),
    DELETE_BOARD_SUCCESS("BD002", "게시글 삭제 성공"),

    GET_BOARD_SUCCESS("BD100", "게시글 조회 성공"),
    GET_BOARD_LIST_SUCCESS("BD101", "게시글 목록 조회 성공"),

    //게시글 댓글 (BoardCOmment) 응답 상태
    // Head Name : BC
    POST_BOARDCOMMENT_SUCCESS("BC000", "댓글 업로드 성공"),
    UPDATE_BOARDCOMMENT_SUCCESS("BC001", "댓글 수정 성공"),
    DELETE_BOARDCOMMENT_SUCCESS("BC002", "댓글 삭제 성공"),
    GET_BOARDCOMMENT_LIST_SUCCESS("BC100", "댓글 목록 조회 성공"),
    ;

    //책 (Book) 응답 상태
    // Head Name : B

    //북리뷰 (BookReview) 응답 상태
    // Head Name : BR

    // 스터디 활동일지 (StudyActivityLog) 응답 상태
    // Head Name : SAL

    // 스터디 그룹 (StudyGroup) 응답 상태
    // Head Name : SG

    // 스터디 계획 (StudyPlan) 응답 상태
    // Head Name : SP


    private final String code;
    private final String message;
}
