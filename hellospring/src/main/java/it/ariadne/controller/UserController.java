package it.ariadne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.ariadne.dao.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	
	private UserRepository userRepository;
	
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@RequestMapping(value="/find/{cognome}", method = RequestMethod.GET)
	public String messagesTemplate(@PathVariable String cognome, Model model) {						
		model.addAttribute(userRepository.findByCognome(cognome));
		return "messages";
	}
	
}
