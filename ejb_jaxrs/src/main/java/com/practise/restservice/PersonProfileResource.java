package com.practise.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.practise.data.Person;
import com.practise.data.PersonProfile;

@Path("profile")
/*@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})*/
public class PersonProfileResource {

	private PersonProfileService pr=new PersonProfileService();
	
	@GET
	/*@Path("random")*/
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonProfile> getProfiles(){
		
		/*PersonProfile p=new  PersonProfile ("Mohit","darmwal",456,"Profile1");
		//PersonProfile p1=new PersonProfile ("Himesh","Rajpal",908,"Profile2");
		List<PersonProfile> ls= new ArrayList<>();
		ls.add(p);
		//ls.add(p1);
		return ls;*/
		
		
		return pr.getAllProfiles();
	}
	
	
	
/*public String getProfiles(){
		
		return pr.getallProfiles();
	}*/
	

	@GET
	@Path("{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PersonProfile getProfile(@PathParam("profileName") String pn)
	{
		return pr.getProfile(pn);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PersonProfile addProfile(PersonProfile per)
	{
		return pr.addProfile(per);
	}
	
	@PUT
	@Path("{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PersonProfile updateProfile(@PathParam("profileName") String pn,PersonProfile per)
	{
		per.setProfile(pn);
		return pr.updateProfile(per);
	}
	
	@DELETE
	@Path("{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profileName") String pn)
	{
		pr.removeProfile(pn);
	}

	
}
