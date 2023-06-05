package com.example.demo.svc;

import java.util.List;



import com.example.demo.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> selectBoardList();
	public BoardVO selectOneBoard(int id);
	public int insertBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public int deleteBoard(int id);

}
