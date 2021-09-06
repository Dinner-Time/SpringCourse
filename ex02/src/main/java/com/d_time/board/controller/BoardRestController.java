package com.d_time.board.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.d_time.board.domain.BoardVO;

@Controller
public class BoardRestController {
	
	@RequestMapping("test1")
	@ResponseBody
	public Map<String, Object> test1(@RequestParam String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		if(id.equals("admin")) {
			map.put("result", "관리자");
		} else {
			map.put("result", "일반인");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="test2"
					, method = RequestMethod.GET
					, produces = {
							MediaType.APPLICATION_JSON_VALUE
							, MediaType.APPLICATION_XML_VALUE        
							}
					)
	public BoardVO test2(BoardVO vo) {
		vo.setRegdate(new Date());
		return vo;
	}
}
