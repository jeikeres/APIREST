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

@Path("/transferencias")
public class TransferenciasResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	TransferenciaService transferenciaService;
	
	public TransferenciasResource() {
		transferenciaService = new TransferenciaService();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Transferencia> getTransferencias() {
		return transferenciaService.getTransferenciasAsList();
	}
	
	// URI: /rest/transferencias/count
	@GET
	@Path("count")	
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
			return String.valueOf(transferenciaService.getTransferenciasCount());
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//https://apirest.mybluemix.net/rest/transferencias?id=1007&message=diego
	public void createTransferencia(@FormParam("id") String id,
			@FormParam("message") String message,
			@Context HttpServletResponse servletResponse) throws IOException {
		Transferencia transferencia = new Transferencia(id, message);
		//delay en la transferencia
		try{
	        Thread.sleep(5000);
	     }catch(InterruptedException e){
	    	 
	     }
		transferenciaService.createTransferencia(transferencia);
		servletResponse.sendRedirect("./transferencias/");
	}
	
	@Path("{transferencia}")
	public TransferenciaResource gettransferencia(@PathParam("transferencia") String id) {
		return new TransferenciaResource(uriInfo, request, id);
	}

}
