package com.d_time.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.d_time.board.domain.BoardVO;
import com.d_time.board.domain.Criteria;

/* Naming Rules
	1) method의 시작은 table이름(vo의 앞단어) ex) board
	2) method의 중간은 CRUD중 어떤 기능인지 표현
	    => 등록은 insert
	    => 수정은 update
	    => 삭제는 delete
	    => 단건 조회는 read
	    => 여러 건 조회는 getList
	3) method의 마지막은 기능상세를 표현
	
	ex) board테이블에 한 건 등록을 하면서 등록한 글을 조회한다.
			  => public void boardInsertReadIt(BoardVO vo);
*/							

@Repository
public interface BoardMapper {
	// 등록
	public void insert(BoardVO vo);
	// 수정
	public void update(BoardVO vo);
	// 삭제
	public void delete(BoardVO vo);
	// 전체 글 갯수
	public int getTotalCount(Criteria cri);
	// 전체 조회
	List<BoardVO> getList(Criteria cri);
	// 단건 조회
	BoardVO read(BoardVO vo);
}
