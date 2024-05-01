package com.ninjatrip.comment.service;

import com.ninjatrip.comment.dto.Comment;
import com.ninjatrip.comment.dto.DeleteCommentReq;

public interface CommentService {
    void writeComment(Comment comment) throws Exception;
    void updateComment(Comment comment) throws Exception;
    void deleteComment(DeleteCommentReq request) throws Exception;
}
