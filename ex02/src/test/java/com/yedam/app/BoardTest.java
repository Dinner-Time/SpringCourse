package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.d_time.board.domain.BoardVO;
import com.d_time.board.service.BoardService;
import com.d_time.common.domain.Criteria;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*.xml")
@Slf4j
public class BoardTest {
	
	@Autowired
	private BoardService boardDAO;
	@Autowired
	private BoardVO board;

	@Test
	public void testGetList() {
		Criteria cri = new Criteria(1,10);
		cri.setType("T");
		cri.setKeyword("수정");
		log.info(boardDAO.getList(cri).toString());
	}
	
	// @Test
	public void testRead() {
		board.setBno(5);
		log.info(boardDAO.read(board).toString());
	}
	
	//@Test
	@Rollback
	public void testDelete() {
		board.setBno(1);
		boardDAO.delete(board);
	}
	
	//@Test
	public void testInsert() {
		board.setTitle("test"+board.getBno());
		board.setContent("test"+board.getBno()+"content");
		board.setWriter("user1");
		boardDAO.insert(board);
		boardDAO.read(board);
	}
	
	//@Test
	public void testUpdate() {
		board.setBno(4);
		board.setTitle("test"+board.getBno()+"update");
		board.setContent("test"+board.getBno()+"content update");
		boardDAO.update(board);
		boardDAO.read(board);
	}

}
