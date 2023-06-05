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

import com.example.demo.svc.BoardService;
import com.example.demo.vo.BoardVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MyController {
	private BoardService service;
	
	@Autowired
	public MyController(BoardService service) {
		this.service = service;
	}
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/getBoardList", produces = "application/json; charset=utf8")
	@ResponseBody
	public String getBoardList() {
		
		List<BoardVO> list = service.selectBoardList();
		
		JSONArray array = new JSONArray();
		for(BoardVO vo : list) {
			JSONObject obj = new JSONObject();
			obj.put("id", vo.getId());
			obj.put("bname", vo.getBname());
			obj.put("bwriter", vo.getBwriter());
			obj.put("cntComm", vo.getCntComm());
			array.add(obj);
		}
		return array.toJSONString(); 
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/getOneBoard", produces = "application/json; charset=utf8")
	@ResponseBody
	public String getOneBoard(int id) {
		BoardVO vo = service.selectOneBoard(id);
		ObjectMapper ob = new ObjectMapper();
		String jsonstr = "";
		try {
			jsonstr = ob.writeValueAsString(vo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonstr;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(path = "/setOneBoard", method = RequestMethod.POST)
	@ResponseBody
	public int setBoard(@RequestBody BoardVO vo) {
		int id = service.insertBoard(vo);
		if(id > 0) {
			return vo.getId();
		}else {
			return 0;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(path = "/modifyOneBoard", method = RequestMethod.POST)
	@ResponseBody
	public int modifyBoard(@RequestBody BoardVO vo) {
		int id = service.updateBoard(vo);
		if(id > 0) {
			return vo.getId();
		}else {
			return 0;
		}		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(path = "/deleteBoard", method = RequestMethod.GET)
	@ResponseBody
	public int deleteBoard(int id) {
		int result = service.deleteBoard(id);
		if(result > 0) {
			return result;
		}else {
			return 0;
		}	
	}
}
