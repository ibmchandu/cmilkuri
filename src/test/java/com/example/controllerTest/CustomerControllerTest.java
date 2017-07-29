package com.example.controllerTest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import com.example.controller.CustomerController;
import com.example.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@SpringBootTest
@WebAppConfiguration
@TestExecutionListeners({
  DependencyInjectionTestExecutionListener.class,
  DirtiesContextTestExecutionListener.class,
  TransactionalTestExecutionListener.class
 
})
@ComponentScan("com.example")
@EnableMongoRepositories(basePackages="com.example.service")
public class CustomerControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService studentLoginService;
	private MediaType contentType =
	           new MediaType(
	                   MediaType.APPLICATION_JSON.getType(),
	                   MediaType.APPLICATION_JSON.getSubtype(),
	                   Charset.forName("utf8"));

	   @Autowired private WebApplicationContext wac;

	   private MockMvc mockMvc;

	   /*@Before
	   public void setup() {
	       this.mockMvc = webAppContextSetup(this.wac).build();
	   }*/
	@Test
	public void testSaveUserNotes() throws Exception {
		ResultActions result =
              mockMvc.perform(
                              get("/api/details")
                                      
                                      .contentType(contentType))
                      .andExpect(status().isOk())
                      .andExpect((ResultMatcher) content().contentType(contentType));

      result.andDo(MockMvcResultHandlers.print());
  }

	

}