package com.practise.restservice;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.practise.data.Person;

@Path("person")
public class PersonResource   {

	PersonService ps=new PersonService();
	
	@GET
	@Path("random")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Person> getMessages(@QueryParam("year") int year,
			@QueryParam("start") int start,
			@QueryParam("size") int size){
	
		if(year>0)
		{
			return ps.getAllMessagesForYear(year);
		}
		if(start>=0 && size>=0)
		{
			return ps.getAllPersonMessagePaginated(start, size);
		}
		/*//return null; //List<Person> persons;
		Person p=new Person(26,"Mohit",123);
		p.setAge(26);
		p.setId(123);
		p.setName("Mohit");
		return p;*/
		return ps.getallMessage();
	}

	@GET
	@Path("random1")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Person> getMessages1(@BeanParam PersonFilterBean pfb){
	
		if(pfb.getYear()>0)
		{
			return ps.getAllMessagesForYear(pfb.getYear());
		}
		if(pfb.getStart()>=0 && pfb.getSize()>=0)
		{
			return ps.getAllPersonMessagePaginated(pfb.getStart(), pfb.getSize());
		}
		/*//return null; //List<Person> persons;
		Person p=new Person(26,"Mohit",123);
		p.setAge(26);
		p.setId(123);
		p.setName("Mohit");
		return p;*/
		return ps.getallMessage();
	}
	
	
	@GET
	@Path("{personId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Person getMessage(@PathParam("personId") int id)
	{
		return ps.getMessage(id);
	}
	
	
	@GET
	@Path("/link/{personId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Person getMessagelist(@PathParam("personId") int id, @Context UriInfo uri)
	{
		Person per= ps.getMessage(id);
		String url=uri.getAbsolutePathBuilder().path(PersonResource.class).path(Integer.toString(per.getId())).build().toString();
		per.addlink(url, "self");
		String url1=uri.getAbsolutePathBuilder().path(PersonProfileResource.class).path(per.getName()).build().toString();
		per.addlink(url1, "profile");
		
		String url2=uri.getAbsolutePathBuilder().path(PersonResource.class).path(PersonResource.class,"getComment").path(CommentResource.class)
				.resolveTemplate("personId", per.getId()).build().toString();
		per.addlink(url2, "profile");
				
		return per;
	}
	
	
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Person addMessage(Person per)
	{
		return ps.addMessage(per);
	}*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response addMessage(Person per, @Context UriInfo uriInfo)
	{
		Person prsn= ps.addMessage(per);
		String s= String.valueOf(per.getId());
		URI uri= uriInfo.getAbsolutePathBuilder().path(s).build();
		//return Response.status(Status.CREATED).entity(ps.addMessage(per)).build();
		return Response.created(uri).entity(ps.addMessage(per)).build(); 
	}
	
	@PUT
	@Path("{personId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Person updatePerson(@PathParam("personId") int id,Person per)
	{
		per.setId(id);
		return ps.updateMessage(per);
	}
	
	@DELETE
	@Path("{personId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void deletePerson(@PathParam("personId") int id)
	{
		ps.removeMessage(id);
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("{personId}/comments")
	public CommonSubResource getCommon()
	{
		return new CommonSubResource();
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("{personId}/Newcomments")
	public CommentResource getComment()
	{
		return new CommentResource();
	}
	
}

