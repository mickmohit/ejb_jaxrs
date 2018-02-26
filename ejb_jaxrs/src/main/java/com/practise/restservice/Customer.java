package com.practise.restservice;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.practise.ejb.CustomerManager;

@Path("customer")
public class Customer {

	@EJB
	//@Inject
	CustomerManager manager=new CustomerManager();
	
	/*public Customer(CustomerManager manager) {
        this.manager = manager;
    }*/
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getcustomerCount()
	{
		return "<h3>Customer Count"+ manager.getcustomerCount() + "</h3>" ;
	}
	
}
