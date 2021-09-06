package com.yedam.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

/* ControllerTest */

// ===== for controller test =========
@WebAppConfiguration
@ContextConfiguration({ 
	"classpath:/spring/*.xml", 
	"file:src/webapp/WEB-INF/spring/appServlet/*.xml" 
	})
// ====================================
@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
public class BoardControllerTest {
	// ===== for controller test =========
	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;
	// ====================================
	
	@Before // test를 실행하기 전 작업
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) // uri
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
}
