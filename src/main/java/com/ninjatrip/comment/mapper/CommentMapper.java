package com.ninjatrip.comment.mapper;

import com.ninjatrip.comment.dto.Comment;
import com.ninjatrip.comment.dto.DeleteCommentReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    void writeComment(Comment comment);
    void updateComment(Comment comment);
    void deleteComment(DeleteCommentReq deleteCommentReq);
}
