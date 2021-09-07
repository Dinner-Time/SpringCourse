package com.d_time.reply.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Component
public class ReplyVO {
	// 댓글 번호(기본키, seq_reply)
	private long rno;
	// 게시글 번호(외래키)
	private long bno;
	// 댓글 내용
	private String reply;
	// 댓글 작성자
	private String replyer;
	// 작성일자
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date replydate;
	// 수정일자
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date updatedate;
	
}
