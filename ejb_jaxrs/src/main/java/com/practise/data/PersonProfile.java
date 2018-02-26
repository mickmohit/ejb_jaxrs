package com.practise.data;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonProfile {
	
	public String firstname;
	public String lastname;
	public int id;
	public String profile;
	public Date d;
	
	public PersonProfile(){}
	
	public PersonProfile(String firstname, String lastname, int id, String profile) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.profile = profile;
		//this.d=new Date();
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	   public String toString() {
	      return "PersonProfile [firstname=" + firstname + ", lastname=" + lastname +  ",id="+ id+ ", profile=" + profile + "]";
	   }

}
