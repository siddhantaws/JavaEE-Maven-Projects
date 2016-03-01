package com.restfully.shop.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.restfully.shop.domain.Days;

@Provider
public class MyProvider implements ParamConverterProvider 
{
	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) 
	{
		if(rawType.getName().equals(Days.class.getName()))
		{
			ParamConverter converter=new DayConverter();
			return converter;
		}
		return null;
	}
}
