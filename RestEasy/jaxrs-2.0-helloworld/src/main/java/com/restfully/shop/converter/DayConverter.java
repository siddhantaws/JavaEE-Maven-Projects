package com.restfully.shop.converter;

import javax.ws.rs.ext.ParamConverter;
import com.restfully.shop.domain.Days;

public class DayConverter implements ParamConverter<Days>
{
	@Override
	public Days fromString(String name) 
	{
		return new Days(name,null);
	}

	@Override
	public String toString(Days day) 
	{
		return day.getDate();
	}

}
