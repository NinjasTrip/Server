package com.ninjatrip.comment.service;

import com.ninjatrip.comment.dto.Comment;
import com.ninjatrip.comment.dto.DeleteCommentReq;
import com.ninjatrip.comment.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    public List<Comment> getComment(int boardIdx) throws Exception {
        return commentMapper.getComment(boardIdx);
    }

    @Override
    public void writeComment(Comment comment) throws Exception {
        commentMapper.writeComment(comment);
    }

    @Override
    public void updateComment(Comment comment) throws Exception {
        commentMapper.updateComment(comment);
    }

    @Override
    public void deleteComment(DeleteCommentReq request) throws Exception {
        commentMapper.deleteComment(request);
    }
}
