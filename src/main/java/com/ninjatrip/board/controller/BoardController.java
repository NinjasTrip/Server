package com.ninjatrip.board.controller;

import com.ninjatrip.board.dto.Board;
import com.ninjatrip.board.dto.BoardResponseDto;
import com.ninjatrip.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public List<Board> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("/{boardIdx}")
    public BoardResponseDto getBoard(@PathVariable("boardIdx") int boardIdx) {
        return boardService.getBoard(boardIdx);
    }

    @PostMapping("/")
    public void writeBoard(@RequestBody Board board) {
        boardService.writeBoard(board);
    }

    @PatchMapping("/")
    public void modifyBoard(@RequestBody Board board) {
        boardService.modifyBoard(board);
    }

    @DeleteMapping("/{boardIdx}")
    public void deleteBoard(@PathVariable("boardIdx") int boardIdx) {
        boardService.deleteBoard(boardIdx);
    }

}
