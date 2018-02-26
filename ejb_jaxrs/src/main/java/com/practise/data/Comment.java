package com.practise.data;

import java.util.Date;

public class Comment {
 
	private int id;
	private String person;
	private Date date;
	
	public Comment(){}
	
	public Comment(int id, String person, String author)
	{
		id=id;
		person=person;
		author=author;
		date=new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	private String author;
	
}
