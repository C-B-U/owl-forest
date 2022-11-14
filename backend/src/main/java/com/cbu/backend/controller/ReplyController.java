package com.cbu.backend.controller;

import com.cbu.backend.dto.ReplyRequest;
import com.cbu.backend.dto.ReplyResponse;
import com.cbu.backend.dto.ReplyUpdateRequest;
import com.cbu.backend.entity.ReplyRepository;
import com.cbu.backend.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;
    private final ReplyRepository replyRepository;

    //생성
    @PostMapping("api/reply")
    public ResponseEntity<Void> create(@RequestBody ReplyRequest dto){ //@RequestBody : http 요청의 본문 body 변환 후 파라미터로 전달
        replyService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) //이미 생성된 경우는 응답코드 반환,
                .build();
    }
    //단일 조회
    @GetMapping("api/reply/{id}")
    public ResponseEntity<ReplyResponse> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(replyService.getById(id));
    }

    //목록 조회
    @GetMapping("api/reply")
    public ResponseEntity<List<ReplyResponse>> getAllOld(){
        return ResponseEntity
                .ok(replyService.getAllOld());
    }
    //목록 조회 (최신순)
    @GetMapping("api/reply/recent")
    public ResponseEntity<List<ReplyResponse>> getAllRecent(){
        return ResponseEntity
                .ok(replyService.getAllRecent());
    }
    //키워드로 검색
    @GetMapping("api/reply/search")
    public ResponseEntity<List<ReplyResponse>> getByKeyword(@RequestParam(value = "keyword") String keyword){
        return ResponseEntity
                .ok(replyService.getByKeyword(keyword));
    }

    //댓글 수정
    @PutMapping("api/reply/{id}")
    public void putReply(@PathVariable Long id, @RequestBody ReplyUpdateRequest dto) {
        replyService.update(id, dto);
    }

    //댓글 삭제
    @DeleteMapping("api/reply/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        replyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
