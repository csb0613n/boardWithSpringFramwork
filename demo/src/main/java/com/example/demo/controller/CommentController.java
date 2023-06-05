package com.example.demo.controller;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.svc.CommentService;
import com.example.demo.vo.CommentVO;

@Controller
public class CommentController {
	private CommentService service;
	
	@Autowired
	public CommentController(CommentService service) {
		this.service = service;
	}
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/getCommList", produces = "application/json; charset=utf8")
	@ResponseBody
	public String commList(int bid) {
		List<CommentVO> list = service.selectOneBoardCommList(bid);
		JSONArray array = new JSONArray();
		for(CommentVO vo : list) {
			JSONObject obj = new JSONObject();
			obj.put("bid", vo.getBid());
			obj.put("cid", vo.getCid());
			obj.put("cwriter", vo.getCwriter());
			obj.put("ccontent", vo.getCcontent());
			obj.put("submit_date", vo.getSubmit_date());
			array.add(obj);
		}
		return array.toJSONString(); 
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(path = "/setComm", method = RequestMethod.POST)
	@ResponseBody
	public int setComm(@RequestBody CommentVO vo) {
		int result = service.insertComm(vo);
		service.plusCntComm(vo.getBid());
		return result;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(path = "/modfiyComm", method = RequestMethod.POST)
	@ResponseBody
	public int modifyComm(@RequestBody CommentVO vo) {
		int result = service.updateComm(vo);
		return result;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(path = "/deleteComm")
	@ResponseBody
	public int deleteComm(int cid, int bid) {
		int result = service.deleteComm(cid);
		service.minusCntComm(bid);
		return result;
	}
}
