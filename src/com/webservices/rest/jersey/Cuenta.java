package com.webservices.rest.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cuenta {
	
	private String id;
	private String nombre;
	private String saldo;
	
	public Cuenta(){
		
	}
	
	public Cuenta(String id, String nombre, String saldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	
}
