package com.ninjatrip.comment.service;

import com.ninjatrip.comment.dto.Comment;
import com.ninjatrip.comment.dto.DeleteCommentReq;

import java.util.List;

public interface CommentService {

    List<Comment> getComment(int boardIdx) throws Exception;
    void writeComment(Comment comment) throws Exception;
    void updateComment(Comment comment) throws Exception;
    void deleteComment(DeleteCommentReq request) throws Exception;
}
