package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.BoardVO;

@Repository(value = "boardMapper")
public interface BoardMapper {
	
	public List<BoardVO> selectBoardList();
	public BoardVO selectOneBoard(int id);
	public int insertBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(int id);

}
