package com.example.demo.svc;

import java.util.List;

import com.example.demo.vo.CommentVO;

public interface CommentService {
	
	public List<CommentVO> selectOneBoardCommList(int bid);
	public int insertComm(CommentVO vo);
	public int updateComm(CommentVO vo);
	public int deleteComm(int cid);
	public int plusCntComm(int id);
	public int minusCntComm(int id);
}
