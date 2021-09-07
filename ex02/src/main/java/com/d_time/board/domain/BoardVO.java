package com.d_time.board.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Component
public class BoardVO {
	// 글번호
	private long bno;	
	// 제목
	private String title;
	// 내용
	private String content;	
	// 작성자
	private String writer;	
	// 작성일자
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date regdate;	
	// 수정일자
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date updatedate;	
}
