package com.practise.restservice;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.practise.ejb.CustomerManager;

@ApplicationPath("/injrest")
public class MyRestApi extends ResourceConfig {

	
	public MyRestApi(){
	
		packages("com.practise.database");
		packages("com.practise.data");
	packages("com.practise.restservice");
	
	
	// Register my custom provider - not needed if it's in my.package.
 // register(CustomerManager.class);
    
	}
}

/*public class MyRestApi extends javax.ws.rs.core.Application {}
*/