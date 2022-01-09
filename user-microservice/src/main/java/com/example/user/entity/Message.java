package com.example.user.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {

	private String source;
	private String destination;
	private String content;
	
	public Message(){
		
	}
	
	public Message(String source, String dest, String content){
		this.source = source;
		this.destination = dest;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Message: "+"source: "+source+" destination: "+ destination+" content: "+ content;
	}
}