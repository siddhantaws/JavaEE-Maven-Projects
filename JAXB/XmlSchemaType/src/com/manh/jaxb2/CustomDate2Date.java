package com.manh.jaxb2;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomDate2Date extends XmlAdapter<Date, CustomDate>
{

	@Override
	public CustomDate unmarshal(Date v) throws Exception 
	{
		return new CustomDate(v);
	}

	@Override
	public Date marshal(CustomDate v) throws Exception
	{
		return v.getDate();
	}
	
}
