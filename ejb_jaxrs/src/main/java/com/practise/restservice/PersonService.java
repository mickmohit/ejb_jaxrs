package com.practise.restservice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.practise.data.Person;
import com.practise.database.DatabaseStaticClass;
import com.practise.exceptions.DataNotFoundException;

public class PersonService {

	private Map<Integer,Person> person= DatabaseStaticClass.getMessages();
	
	public PersonService()
	{
		person.put(1, new Person (123,"Mohit",456));
		person.put(2, new Person (789,"Himesh",908));
	}
	
	public List<Person> getallMessage()
	{
		/*Person p=new Person(26,"Mohit",123); 
		Person p1=new Person(86,"Himesh",456);
		List<Person> ls= new ArrayList<>();
		ls.add(p);
		ls.add(p1);
		return ls;*/
		return new ArrayList<Person>(person.values());
	}
	
	
	public List<Person>  getAllMessagesForYear(int year)
	{
		List<Person> mesgsForYear=new ArrayList<>();
		Calendar cal= Calendar.getInstance();
		for(Person pr: person.values())
		{
			cal.setTime(pr.getD());
			if(cal.get(Calendar.YEAR)==year)
			{
				mesgsForYear.add(pr);
			}
		}
	return mesgsForYear;
	}
	
	public List<Person> getAllPersonMessagePaginated(int start, int size)
	{
		ArrayList<Person> per= new ArrayList<Person>(person.values());
		if(start+size> per.size())return new ArrayList<Person>();
		return per.subList(start, start+size);
	}
	
	public Person getMessage(int id)
	{
	//return person.get(id);	
	Person p=person.get(id);
	if(p==null)
	{
		throw new DataNotFoundException("Person id with" +id + "not found");
	}
	else
		return p;
	}
	
	public Person addMessage(Person per)
	{
		per.setId(person.size()+1);
		person.put(per.getId(),per);
		return per;
	}

	public Person updateMessage(Person per)
	{
		if(per.getId()<=0)
		{
			return null;
		}
		person.put(per.getId(), per);
		return per;
	}

	public Person removeMessage(int id)
	{
		return person.remove(id);
	}
	
}
