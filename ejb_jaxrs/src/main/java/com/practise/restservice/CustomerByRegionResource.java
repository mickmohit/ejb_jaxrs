package com.practise.restservice;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.practise.ejb.CustomerManager;

@Path("customerByRegion")
public class CustomerByRegionResource {
	
	/*@Context
	private UriInfo context;*/
	
	@EJB
	CustomerManager manager=new CustomerManager();
	
	public CustomerByRegionResource(){}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHTML()
	{
		return "<h3>Customer Count"+ manager.getcustomerCount() + "</h3>" ;

	}

	@GET
	@Path("byRegion")
	@Produces(MediaType.TEXT_HTML)
	public String getCustomerByRegionGet(@QueryParam("r") @DefaultValue("East") String region)
	{
		return "<h3> Customers By Region" +manager.getcustomerbyRegion(region)+ "</h3>";
	}

	@GET
	@Path("{rPath}")
	@Produces(MediaType.TEXT_HTML)
	public String getCustomerByRegionPath(@PathParam("rPath") String region)
	{
		return "<h3> Customers By Region" +manager.getcustomerbyRegion(region)+ "</h3>";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String getCustomerByRegionPOST(@FormParam("region") String Region)
	{
		return "<h3> Customers By Region" +manager.getcustomerbyRegion(Region)+ "</h3>";
	}
	
}
