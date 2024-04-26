package com.ninjatrip.board.service;

import com.ninjatrip.board.dto.Board;
import com.ninjatrip.board.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {

    BoardResponseDto getBoard(int boardIdx);
    List<Board> getBoardList();
    void writeBoard(Board board);
    void modifyBoard(Board board);
    void deleteBoard(int boardIdx);
}
