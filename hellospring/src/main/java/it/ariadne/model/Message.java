package it.ariadne.model;

import java.util.Date;

public class Message {
	
	private String message;
	private Date date;
	private Long id;
	
	public Message(String message, Date date, Long id) {
		this.message = message;
		this.date = date;
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
