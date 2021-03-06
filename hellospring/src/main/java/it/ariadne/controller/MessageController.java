package it.ariadne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.ariadne.dao.MessageRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {

	private MessageRepository messageRepository;

	@Autowired
	public MessageController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String messages(Model model) {
		model.addAttribute(messageRepository.findMessages(Long.MAX_VALUE, 20));
		return "messages";
	}
	
	@RequestMapping(value = "template", method = RequestMethod.GET)
	public String messagesTemplate(Model model) {
		model.addAttribute(messageRepository.getMessageTitles());
		return "messages";
	}
	
	@RequestMapping(value = "jpa", method = RequestMethod.GET)
	public String messagesJpa(Model model) {
		model.addAttribute(messageRepository.getMessageTitles());
		return "messages";
	}
	
}
