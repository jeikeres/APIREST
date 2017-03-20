package com.webservices.rest.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class TransferenciaResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	String id;
	
	TransferenciaService transferenciaService;
	
	public TransferenciaResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		transferenciaService = new TransferenciaService();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Transferencia getTransferencia() {
		Transferencia transferencia = transferenciaService.getTransferencia(id);
		return transferencia;
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Transferencia getTransferenciaAsHtml() {
		Transferencia transferencia = transferenciaService.getTransferencia(id);
		return transferencia;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putTransferencia(JAXBElement<Transferencia> transferenciaElement) {
		Transferencia transferencia = transferenciaElement.getValue();
		Response response;
		if (transferenciaService.getTransferencias().containsKey(transferencia.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		transferenciaService.createTransferencia(transferencia);
		return response;
	}
	
	@DELETE
	//https://apirest.mybluemix.net/rest/transferencias/{id}
	public void deleteTransferencia() {
		transferenciaService.deleteTransferencia(id);
	}
	

}
