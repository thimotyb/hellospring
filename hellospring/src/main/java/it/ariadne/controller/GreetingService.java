package it.ariadne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.ariadne.model.Language;

@Component
public class GreetingService {

	   @Autowired
	   private Language language;
	 
	   public GreetingService() {
	 
	   }
	 
	   public void sayGreeting() {	        
	       String greeting = language.getGreeting();	 
	       System.out.println("Greeting: " + greeting);
	   }
	
}
