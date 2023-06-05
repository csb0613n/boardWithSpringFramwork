package com.example.demo.svc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Resource(name = "boardMapper")
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> selectBoardList() {
		return mapper.selectBoardList();
	}

	@Override
	public BoardVO selectOneBoard(int id) {
		return mapper.selectOneBoard(id);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return mapper.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return mapper.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int id) {
		return mapper.deleteBoard(id);
	}

}
