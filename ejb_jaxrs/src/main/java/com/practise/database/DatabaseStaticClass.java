package com.practise.database;

import java.util.HashMap;
import java.util.Map;


import com.practise.data.Person;
import com.practise.data.PersonProfile;

public class DatabaseStaticClass {

	private static Map<Integer, Person> person= new HashMap<>();
	private static Map<String, PersonProfile> profile= new HashMap<>();
	
	public static Map<Integer, Person> getMessages() {
		return person;
	}
	
	public static Map<String, PersonProfile> getProfiles() {
		return profile;
	}
	
}
