package com.d_time.reply.service;

import java.util.List;

import com.d_time.common.domain.Criteria;
import com.d_time.reply.domain.ReplyVO;

public interface ReplyService {
	// 댓글 한 건 조회
	// (rno기준)
	public ReplyVO read(long rno);

	// 댓글 전체 조회
	// (bno기준)
	public List<ReplyVO> getList(Criteria cri, long bno);

	// 댓글 입력
	// (rno=>시퀀스, bno=>외래키, reply=>내용, replyer=>작성자, replydate=>기본값,
	// updatedate=>기본값)
	public int insert(ReplyVO vo);

	// 댓글 수정
	// (reply만 수정, updatedate=>sysdate)
	public int update(ReplyVO vo);

	// 댓글 삭제
	// (rno기준)
	public int delete(long rno);
}
