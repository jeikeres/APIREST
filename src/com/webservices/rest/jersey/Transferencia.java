package com.webservices.rest.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Transferencia {
	
	private String id;
	private String message;
	
	public Transferencia(){
		
	}
	
	public Transferencia(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
