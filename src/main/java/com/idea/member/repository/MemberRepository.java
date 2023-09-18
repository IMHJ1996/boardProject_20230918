package com.idea.member.repository;

import com.idea.member.dto.MemberDTO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int join(MemberDTO memberDTO) {
        return sql.insert("member.join", memberDTO);
    }
    public List<MemberDTO> findAll() {
        return sql.selectList("member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("member.findById", id);
    }
    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("member.login", memberDTO);
    }

}
