package com.webservices.rest.jersey;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

import com.google.gson.Gson;

@Path("/cuentas")
public class CuentasResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	CuentaService cuentaService;
	
	public CuentasResource() {
		cuentaService = new CuentaService();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String getCuentas() {		
		String lista = new Gson().toJson(cuentaService.getCuentaAsList());
		return lista;
	}
	
	// URI: /rest/cuentas/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(cuentaService.getCuentasCount());
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//https://apirest.mybluemix.net/rest/cuentas?id=1007&nombrecuenta=diego&cuentasaldo=7777777
	public void createCuenta(@FormParam("id") String id,
			@FormParam("nombrecuenta") String nombre,
			@FormParam("cuentasaldo") String saldo,
			@Context HttpServletResponse servletResponse) throws IOException {
		Cuenta cuenta = new Cuenta(id, nombre, saldo);
		cuentaService.createCuenta(cuenta);
		servletResponse.sendRedirect("./cuentas/");
	}
	
	@Path("{cuenta}")
	public CuentaResource getCuenta(@PathParam("cuenta") String id) {
		return new CuentaResource(uriInfo, request, id);
	}

}
