package com.ninjatrip.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeleteCommentReq {
    private int commentIdx;
    private int boardIdx;
}
