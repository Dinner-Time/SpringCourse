package com.d_time.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.d_time.common.domain.Criteria;
import com.d_time.reply.domain.ReplyVO;
import com.d_time.reply.service.ReplyService;

@RequestMapping("/replies")
@RestController
// @Slf4j
public class ReplyRestController {
	@Autowired
	ReplyService replyService;
	
	// 게시글 댓글 전체 조회
	@GetMapping(
			value="/")
	public List<ReplyVO> getList(
			Criteria cri, 
			@RequestParam long bno){
		
		return replyService.getList(cri, bno);
	}
	
	// 댓글 조회
	@GetMapping(
			value="/{rno}")
	public ReplyVO read(
			@PathVariable("rno") long rno) {
		
		return replyService.read(rno);
	}
	
	// 댓글 등록
	@PostMapping(
			value="/")
	public ReplyVO insert(
			ReplyVO vo) {
		
		replyService.insert(vo);
		return replyService.read(vo.getRno());
	}
	
	// 댓글 수정
	@PutMapping(
			value="/")
	public ReplyVO update(
			@RequestBody ReplyVO vo) {	
		replyService.update(vo);
		return replyService.read(vo.getRno());
	}
	
	// 댓글 삭제
	@DeleteMapping(
			value="/{rno}")
	public long delete(
			@PathVariable("rno") long rno) {
		replyService.delete(rno);
		return rno;
	}
}
