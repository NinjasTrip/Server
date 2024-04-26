package com.ninjatrip.board.mapper;

import com.ninjatrip.board.dto.Board;
import com.ninjatrip.board.dto.BoardResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    BoardResponseDto findByBoardIdx(int boardIdx);
    List<Board> findByAll();
    void writeBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(int boardIdx);
}