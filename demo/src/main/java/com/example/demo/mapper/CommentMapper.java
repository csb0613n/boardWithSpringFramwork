package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.CommentVO;

@Repository(value = "commentMapper")
public interface CommentMapper {
	
	public List<CommentVO> selectOneBoardCommList(int bid);
	public int insertComm(CommentVO vo);
	public int updateComm(CommentVO vo);
	public int deleteComm(int cid);
	public int plusCntComm(int id);
	public int minusCntComm(int id);
}
