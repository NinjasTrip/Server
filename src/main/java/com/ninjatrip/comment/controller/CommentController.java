package com.ninjatrip.comment.controller;

import com.ninjatrip.comment.dto.Comment;
import com.ninjatrip.comment.dto.DeleteCommentReq;
import com.ninjatrip.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 작성
     */
    public ResponseEntity<String> writeComment(@RequestBody Comment comment) {
        try {
            commentService.writeComment(comment);
            return ResponseEntity.status(HttpStatus.OK).body("작성 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("작성에 오류가 발생했습니다.");
        }
    }

    /**
     * 댓글 수정
     */
    public ResponseEntity<String> updateComment(@RequestBody Comment comment) {
        try {
            commentService.updateComment(comment);
            return ResponseEntity.status(HttpStatus.OK).body("작성 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("수정에 오류가 발생했습니다.");
        }
    }

    /**
     * 댓글 삭제
     */
    public ResponseEntity<String> deleteComment(@RequestBody DeleteCommentReq deleteCommentReq) {
        try {
            commentService.deleteComment(deleteCommentReq);
            return ResponseEntity.status(HttpStatus.OK).body("작성 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("삭제에 오류가 발생했습니다.");
        }
    }
}
