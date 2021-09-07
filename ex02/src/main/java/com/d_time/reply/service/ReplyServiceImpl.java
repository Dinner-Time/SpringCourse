package com.d_time.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d_time.common.domain.Criteria;
import com.d_time.reply.domain.ReplyVO;
import com.d_time.reply.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired 
	ReplyMapper replyDAO;
	
	@Override
	public ReplyVO read(long rno) {
		return replyDAO.read(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, long bno) {
		return replyDAO.getList(cri, bno);
	}

	@Override
	public int insert(ReplyVO vo) {
		return replyDAO.insert(vo);
	}

	@Override
	public int update(ReplyVO vo) {
		return replyDAO.update(vo);
	}

	@Override
	public int delete(long rno) {
		return replyDAO.delete(rno);
	}

}
