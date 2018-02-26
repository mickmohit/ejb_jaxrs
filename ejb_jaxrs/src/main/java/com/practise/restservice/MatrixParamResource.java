package com.practise.restservice;

import javax.ws.rs.Consumes;
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

@Path("injectM")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class MatrixParamResource {

	//http://localhost/EJBJAXRS/injrest/injectM/anoo;param=value
	
	@GET
	@Path("anoo")
	public String getmessage(@MatrixParam("param") String matrixparam,
			@HeaderParam("header") String head, @CookieParam("JSESSIONID") String cookie)
	{
		return "Matrix param is:"+ matrixparam   + "__Header param :" + head + "__Cookie Value:" +cookie;
	}

	@GET
	@Path("as")
	public String getmessage()
	{
		return "Matrix param is YOOOOO";
	}

	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uri, @Context HttpHeaders hd)
	{
		String path=uri.getAbsolutePathBuilder().toString();
		String cookie=hd.getCookies().toString();
		return "URiPath:="+path + "_COkkies:"+cookie;
	}
	
}
