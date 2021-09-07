package com.d_time.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.d_time.board.domain.BoardVO;
import com.d_time.board.service.BoardService;
import com.d_time.common.domain.Criteria;
import com.d_time.common.domain.PageVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
// @SessionAttributes("criteria")
public class BoardController {
	
	@Autowired BoardService boardDAO;
	
	// 조회는 get, 이외에는 post
	
	// 전체조회
	@GetMapping("/list")
	public void getList(Model model, Criteria cri) {
		model.addAttribute("list", boardDAO.getList(cri));
		model.addAttribute("pageMaker", new PageVO(cri, boardDAO.getTotalCount(cri)));
	}
	
	// 단건조회
	@GetMapping("/get")
	public void read(BoardVO board, Criteria cri, Model model) {
		model.addAttribute("board", boardDAO.read(board));
	}
	
	// 수정처리 (굳이 redirect를?)
	@PostMapping("/update")
	public String update(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		boardDAO.update(board);
		rttr.addFlashAttribute("result", "update");
		rttr.addFlashAttribute(cri);
		return "redirect:/board/list";
	}
	
	/* RESTful 개발 방식
	 *  같은 uri이지만 method 방식에 따라 처리 방법이 달라진다
	 * 		=> Get : read
	 * 		=> Put : update
	 * 		=> Post : insert
	 * 		=> Delete : delete
	 */
	
	// 글쓰기 페이지
	@GetMapping("/register")
	public void registerForm() {}
	
	// 글쓰기 처리
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		boardDAO.insert(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	// 삭제
	@PostMapping("/delete")
	public String delete(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		boardDAO.delete(board);
		rttr.addFlashAttribute("result", "delete");
		rttr.addFlashAttribute(cri);
		return "redirect:/board/list";
	}
}
