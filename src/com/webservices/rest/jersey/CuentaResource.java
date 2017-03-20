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

public class CuentaResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	String id;
	
	CuentaService cuentaService;
	
	public CuentaResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		cuentaService = new CuentaService();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Cuenta getCuenta() {
		Cuenta cuenta = cuentaService.getCuenta(id);
		return cuenta;
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Cuenta getCuentaAsHtml() {
		Cuenta cuenta = cuentaService.getCuenta(id);
		return cuenta;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putCuenta(JAXBElement<Cuenta> cuentaElement) {
		Cuenta cuenta = cuentaElement.getValue();
		Response response;
		if (cuentaService.getCuentas().containsKey(cuenta.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		cuentaService.createCuenta(cuenta);
		return response;
	}
	
	@DELETE
	//https://apirest.mybluemix.net/rest/cuentas/{id}
	public void deleteCuenta() {
		cuentaService.deleteCuenta(id);
	}

}
