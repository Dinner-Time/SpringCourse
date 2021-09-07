package com.d_time.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d_time.board.domain.BoardVO;
import com.d_time.board.mapper.BoardMapper;
import com.d_time.common.domain.Criteria;

@Service // service interface가 아닌 impl에서
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardDAO;
	
	@Override
	public void insert(BoardVO vo) {
		boardDAO.insert(vo);
	}

	@Override
	public void update(BoardVO vo) {
		boardDAO.update(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		boardDAO.delete(vo);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return boardDAO.getList(cri);
	}

	@Override
	public BoardVO read(BoardVO vo) {
		return boardDAO.read(vo);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDAO.getTotalCount(cri);
	}

}
