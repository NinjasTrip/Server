package com.ninjatrip.board.service;

import com.ninjatrip.board.dto.Board;
import com.ninjatrip.board.dto.BoardResponseDto;
import com.ninjatrip.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public BoardResponseDto getBoard(int boardIdx) {
        boardMapper.incrementHit(boardIdx);
        return boardMapper.findByBoardIdx(boardIdx);
    }

    @Override
    public List<Board> getBoardList() {
        return boardMapper.findByAll();
    }

    @Override
    public void writeBoard(Board board) {
        boardMapper.writeBoard(board);
    }

    @Override
    public void modifyBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int boardIdx) {
        boardMapper.deleteBoard(boardIdx);
    }
}
