package com.idea.member.repository;

import com.idea.member.dto.BoardDTO;
import com.idea.member.dto.BoardFileDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public BoardDTO save(BoardDTO boardDTO) {
        System.out.println("insert 전 boardDTO = " + boardDTO);
        sql.insert("Board.save", boardDTO);
        System.out.println("insert 후 boardDTO = " + boardDTO);
        return boardDTO;
    }
    public void saveFile(BoardFileDTO boardFileDTO) {
        sql.insert("Board.saveFile", boardFileDTO);
    }
    public int boardCount() {
        return sql.selectOne("Board.count");
    }
}
