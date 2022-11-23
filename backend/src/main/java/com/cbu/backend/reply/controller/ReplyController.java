package com.cbu.backend.reply.controller;

import com.cbu.backend.reply.dto.ReplyRequest;
import com.cbu.backend.reply.dto.ReplyResponse;
import com.cbu.backend.reply.dto.UpdateReplyRequest;
import com.cbu.backend.reply.entity.ReplyRepository;
import com.cbu.backend.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/reply")
public class ReplyController {

    private final ReplyService replyService;
    private final ReplyRepository replyRepository;

    //생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ReplyRequest dto){ //@RequestBody : http 요청의 본문 body 변환 후 파라미터로 전달
        replyService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED) //이미 생성된 경우는 응답코드 반환,
                .build();
    }
    //단일 조회
    @GetMapping("{id}")
    public ResponseEntity<ReplyResponse> findById(@PathVariable Long id){
        return ResponseEntity
                .ok(replyService.findById(id));
    }

    //목록 조회
    @GetMapping
    public ResponseEntity<List<ReplyResponse>> getAllOld(){
        return ResponseEntity
                .ok(replyService.findAllOld());
    }
    //목록 조회 (최신순)
    @GetMapping("recent")
    public ResponseEntity<List<ReplyResponse>> getAllRecent(){
        return ResponseEntity
                .ok(replyService.findAllRecent());
    }
    //키워드로 검색
    @GetMapping("search")
    public ResponseEntity<List<ReplyResponse>> getByKeyword(@RequestParam(value = "keyword") String keyword){
        return ResponseEntity
                .ok(replyService.findByKeywordContains(keyword));
    }

    //댓글 수정
    @PutMapping("{id}")
    public void putReply(@PathVariable Long id, @RequestBody UpdateReplyRequest dto) {
        replyService.update(id, dto);
    }

    //댓글 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        replyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
