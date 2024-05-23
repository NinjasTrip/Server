package com.ninjatrip.board.controller;

import com.ninjatrip.board.dto.Board;
import com.ninjatrip.board.dto.BoardResponseDto;
import com.ninjatrip.board.service.BoardService;
import com.ninjatrip.plan.dto.Plan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getBoardList() {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        try {
            List<Board> boards =  boardService.getBoardList();
            status = HttpStatus.OK;
            resultMap.put("articles", boards);
        } catch (Exception e) {
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("/{boardIdx}")
    public ResponseEntity<Map<String, Object>> getBoard(@PathVariable("boardIdx") int boardIdx) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        try {
            BoardResponseDto board = boardService.getBoard(boardIdx);
            status = HttpStatus.OK;
            resultMap.put("article", board);
        } catch (Exception e) {
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping
    public ResponseEntity<?> writeBoard(@RequestBody Board board) {
        try {
            boardService.writeBoard(board);
            return ResponseEntity.status(HttpStatus.OK).body("작성 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("작성 실패");
        }
    }

    @PatchMapping("/modify/{boardIdx}")
    public ResponseEntity<?> modifyBoard(@RequestBody Board board) {
        try {
            boardService.modifyBoard(board);
            return ResponseEntity.status(HttpStatus.OK).body("수정 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정 실패");
        }
    }

    @DeleteMapping("/{boardIdx}")
    public ResponseEntity<?> deleteBoard(@PathVariable("boardIdx") int boardIdx) {
        try {
            boardService.deleteBoard(boardIdx);
            return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 실패");
        }
    }

    private ResponseEntity<String> exceptionHandler(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
}
