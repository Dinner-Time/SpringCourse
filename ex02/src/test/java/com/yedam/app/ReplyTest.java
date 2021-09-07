package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.d_time.common.domain.Criteria;
import com.d_time.reply.domain.ReplyVO;
import com.d_time.reply.mapper.ReplyMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*.xml")
@Slf4j
public class ReplyTest {

	@Autowired ReplyMapper replyDAO;
	@Autowired ReplyVO reply;
	
	@Test
	public void getListTest() {
		replyDAO.getList(new Criteria(), 332L);
	}
	
	// @Test
	public void insertTest() {
		reply.setBno(332);
		reply.setReply("test3");
		reply.setReplyer("user1");
		replyDAO.insert(reply);
	//	log.info(replyDAO.getList(reply).toString());
	}
	
	// @Test
	public void readTest() {
		reply.setRno(2);
	//	log.info(replyDAO.read(reply).toString());
	}
	
	// @Test
	public void updateTest() {
		reply.setRno(2);
		reply.setReply("updateTest");
		replyDAO.update(reply);
	//	log.info(replyDAO.read(reply).toString());
	}
	
	// @Test
	public void deleteTest() {
		reply.setRno(1);
		reply.setBno(332);
	//	replyDAO.delete(reply);
	//	log.info(replyDAO.getList(reply).toString());
	}

}
