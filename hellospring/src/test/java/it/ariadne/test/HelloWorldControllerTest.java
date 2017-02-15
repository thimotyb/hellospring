package it.ariadne.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import it.ariadne.config.ApplicationContextConfig;
import it.ariadne.controller.HelloWorldController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class HelloWorldControllerTest {
	
	@Test
	public void testHomePage() throws Exception {
		HelloWorldController controller = new HelloWorldController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/hello")).andExpect(view().name("helloworld"));
	}
	
}
