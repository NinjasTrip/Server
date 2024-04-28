package com.ninjatrip.board.controller;

import com.ninjatrip.board.dto.Board;
import com.ninjatrip.board.dto.BoardResponseDto;
import com.ninjatrip.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<?> getBoardList() {
        try {
            List<Board> boards =  boardService.getBoardList();
            return ResponseEntity.status(HttpStatus.OK).body(boards);
        } catch (Exception e) {
            return exceptionHandler(e);
        }

    }

    @GetMapping("/{boardIdx}")
    public ResponseEntity<?> getBoard(@PathVariable("boardIdx") int boardIdx) {
        try {
            BoardResponseDto board = boardService.getBoard(boardIdx);
            return ResponseEntity.status(HttpStatus.OK).body(board);
        } catch (Exception e) {
            return exceptionHandler(e);
        }
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

    @PatchMapping
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
