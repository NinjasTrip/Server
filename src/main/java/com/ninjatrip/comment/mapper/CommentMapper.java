package com.ninjatrip.comment.mapper;

import com.ninjatrip.comment.dto.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getComment(int boardIdx);
    void writeComment(Comment comment);
    void updateComment(Comment comment);
    void deleteComment(int commentIdx);
}
