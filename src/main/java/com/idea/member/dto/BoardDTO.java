package com.idea.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Getter
@Setter
@ToString
public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardPass;
    private String boardContents;
    private int boardHits;
    private int cratedAT;
    private int fileAttached;
    private List<MultipartFile> boardFile;




}
