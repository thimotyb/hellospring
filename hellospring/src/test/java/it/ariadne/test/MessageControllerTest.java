package it.ariadne.test;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import it.ariadne.config.ApplicationContextConfig;
import it.ariadne.controller.MessageController;
import it.ariadne.dao.MessageRepository;
import it.ariadne.model.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class MessageControllerTest {

	@Test
	  public void shouldShowRecentMessages() throws Exception {
		
	    List<Message> expectedMessages = createMessageList(20);
	    MessageRepository mockRepository = mock(MessageRepository.class);
	    when(mockRepository.findMessages(Long.MAX_VALUE, 20))
	        .thenReturn(expectedMessages);

	    MessageController controller = new MessageController(mockRepository);
	    MockMvc mockMvc = standaloneSetup(controller)
	        .setSingleView(new InternalResourceView("/WEB-INF/pages/messages.jsp"))
	        .build();

	    mockMvc.perform(get("/messages"))
	       .andExpect(view().name("messages"))
	       .andExpect(model().attributeExists("messageList"))
	       .andExpect(model().attribute("messageList", 
	                  hasItems(expectedMessages.toArray())));
	  }

	private List<Message> createMessageList(int count) {
		List<Message> messages = new ArrayList<Message>();
		for (int i = 0; i < count; i++) {
			messages.add(new Message("Message " + i, new Date(), new Long(i)));
		}
		return messages;

	}
	
}
