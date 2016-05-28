package com.appspot.krishnacgh.messenger.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/inject")
public class InjectResource {
	
	@GET
	@Path("annotation")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAnnotationValues(@MatrixParam("ann") String ann,
									  @HeaderParam("heady") String heady,
									  @CookieParam("myCookieName") String cook){
		return "Annotation "+ann+", Header "+heady+", Cookie "+cook;
	}
	
	@GET
	@Path("context")
	@Produces(MediaType.TEXT_PLAIN)
	public String getContextValues(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
		return httpHeaders.getCookies().keySet().toString();
	}

}
