package com.practise.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.practise.data.Comment;
import com.practise.data.Person;
import com.practise.data.PersonProfile;
import com.practise.database.DatabaseStaticClass;

public class CommentService {

	private Map<Integer,Person> person= DatabaseStaticClass.getMessages();
	
	
	
	public List<Comment> getAllComment(int personId)
	{
		Map<Integer, Comment> comments=person.get(personId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(int personId, int commentId)
	{
		Map<Integer, Comment> comments=person.get(personId).getComments();
	return comments.get(commentId);
	}
	
	public Comment addComment(int personId, Comment comment)
	{
		Map<Integer, Comment> comments=person.get(personId).getComments();
		
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;
	}

	public Comment updateComment(int personId, Comment comment)
	{
		Map<Integer, Comment> comments=person.get(personId).getComments();
		if(comment.getId()<=0)
		{
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(int personId, int commentid)
	{

		Map<Integer, Comment> comments=person.get(personId).getComments();
		return comments.remove(commentid);
	}
	
	
}
