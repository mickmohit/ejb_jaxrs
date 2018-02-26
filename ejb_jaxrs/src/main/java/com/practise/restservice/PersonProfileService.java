package com.practise.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.practise.data.Person;
import com.practise.data.PersonProfile;
import com.practise.database.DatabaseStaticClass;

public class PersonProfileService {

private Map<String,PersonProfile> profile= DatabaseStaticClass.getProfiles();
	
public PersonProfileService()
{
	profile.put("Profile1", new PersonProfile ("Mohit","darmwal",456,"Profile1"));
	profile.put("Profile2", new PersonProfile ("Himesh","Rajpal",908,"Profile2"));
}


	
	public List<PersonProfile> getAllProfiles()
	{
		/*PersonProfile p=new  PersonProfile ("Mohit","darmwal",456,"Profile1");
		//PersonProfile p1=new PersonProfile ("Himesh","Rajpal",908,"Profile2");
		List<PersonProfile> ls= new ArrayList<>();
		ls.add(p);
		//ls.add(p1);
		return ls;*/
		return new ArrayList<PersonProfile>(profile.values());
	}
/*
public String getallProfiles()
{
	
return "Mohit";
}	
*/

	public PersonProfile getProfile(String profileName)
	{
	return profile.get(profileName);
	}
	
	public PersonProfile addProfile(PersonProfile per)
	{
		per.setId(profile.size()+1);
		profile.put(per.getProfile(),per);
		return per;
	}

	public PersonProfile updateProfile(PersonProfile per)
	{
		if(per.getProfile().isEmpty())
		{
			return null;
		}
		profile.put(per.getProfile(), per);
		return per;
	}

	public PersonProfile removeProfile(String prof)
	{
		return profile.remove(prof);
	}
	
}
