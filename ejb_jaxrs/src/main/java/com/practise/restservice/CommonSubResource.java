package com.practise.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommonSubResource {

	@GET
	public String returnMethod()
	{
		return "New Sub Resource";
	}
	@GET
	@Path("{s}")
	public String returnMethod1(@PathParam("s") int sd,@PathParam("{personId}") int pId)
	{
		return "New Sub Resource"+sd +"asas" +pId;
	}
	
	
	
	/*@GET
	@Path("/{commonId}")
	public String test(@PathParam("{personId}") int pId, @PathParam("{commonId}") int cId)
	{
		return "common id:asasasas" +12+ "____Perosn id:"+ pId;
	}*/
	
}
