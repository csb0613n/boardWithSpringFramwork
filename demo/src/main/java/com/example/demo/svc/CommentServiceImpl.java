package com.example.demo.svc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService{

	@Resource(name = "commentMapper")
	private CommentMapper mapper;

	@Override
	public List<CommentVO> selectOneBoardCommList(int bid) {
		return mapper.selectOneBoardCommList(bid);
	}

	@Override
	public int insertComm(CommentVO vo) {
		return mapper.insertComm(vo);
	}

	@Override
	public int updateComm(CommentVO vo) {
		return mapper.updateComm(vo);
	}

	@Override
	public int deleteComm(int cid) {
		return mapper.deleteComm(cid);
	}

	@Override
	public int plusCntComm(int id) {
		return mapper.plusCntComm(id);
	}

	@Override
	public int minusCntComm(int id) {
		return mapper.minusCntComm(id);
	}
}

