package com.javatpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("subj")
public class Subject {

	@Value("Economics")
	private String subject;
	
	public Subject(){ }
	
    public Subject(String subject){
    	this.subject = subject;
    }

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void sayHi(){
		System.out.println("Hello from Subject class");
	}
	
}
