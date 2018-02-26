package com.practise.ejb;

import javax.ejb.Stateless;

@Stateless
public class CustomerManager {

	public int getcustomerCount()
	{
		return 27;
	}
	
	public int getcustomerbyRegion(String Region)
	{
		if(Region.equalsIgnoreCase("West"))
		{
			return 12;
		}
		else if(Region.equalsIgnoreCase("East"))
		{
			return 15;
		}
		else {
		return 0;}
	}
	
}
