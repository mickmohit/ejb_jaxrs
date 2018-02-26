package com.practise.restservice;

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

import com.practise.data.Comment;


@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class CommentResource {
	
private CommentService cs=new CommentService();

@GET
public List<Comment> getAllcomments(@PathParam("personId") int personId)
{
return cs.getAllComment(personId);	
}

@GET
@Path("/{commentId}")
public Comment getComment(@PathParam("personId") int personId, @PathParam("commentId") int cid)
{
return cs.getComment(personId, cid);
}

@POST
public Comment addComment(@PathParam("personId") int personId, Comment c)
{
return cs.addComment(personId, c);
}

@PUT
@Path("/{commentId}")
public Comment updateComment(@PathParam("personId") int personId, @PathParam("commentId") int cid, Comment c)
{
c.setId(cid);
return cs.updateComment(personId, c);
}


@DELETE
@Path("/{commentId}")
public void deleteComment(@PathParam("personId") int personId, @PathParam("commentId") int cid)
{
 cs.removeComment(personId, cid);
}

}
