package com.practise.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
public class Person implements Serializable {
	
	
	
	private int id;   
	

	private String name;
	
	
	private int age;

	Date d;
	
	private Map<Integer,Comment> comments=new HashMap<>();
	
	private List<Link> li=new ArrayList<>();
	
	public void addlink(String url, String ref)
	{
		Link l=new Link();
		l.setLink(url);
		l.setRef(ref);
		li.add(l);
	}
	
	public List<Link> getLi() {
		return li;
	}

	public void setLi(List<Link> li) {
		this.li = li;
	}

	public Date getD() {
		return d;
	}

	@XmlTransient
	public Map<Integer, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public Person(){}
	
	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.d=new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	   public String toString() {
	      return "Person [p-id=" + id + ", name=" + name + ", age=" + age + "]";
	   }
	

}
