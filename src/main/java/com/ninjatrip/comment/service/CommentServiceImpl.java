package com.ninjatrip.comment.service;

import com.ninjatrip.comment.dto.Comment;
import com.ninjatrip.comment.dto.DeleteCommentReq;
import com.ninjatrip.comment.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    public void writeComment(Comment comment) throws Exception {

    }

    @Override
    public void updateComment(Comment comment) throws Exception {

    }

    @Override
    public void deleteComment(DeleteCommentReq request) throws Exception {

    }
}
