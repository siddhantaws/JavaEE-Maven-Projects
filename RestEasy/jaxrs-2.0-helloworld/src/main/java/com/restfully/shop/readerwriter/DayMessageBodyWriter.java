package com.restfully.shop.readerwriter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.restfully.shop.domain.Days;

@Provider
@Produces("text/plain")
public class DayMessageBodyWriter implements MessageBodyWriter<Days> 
{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) 
	{
		return Days.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(Days t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) 
	{
		return -1;
	}

	@Override
	public void writeTo(Days t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException 
	{
		entityStream.write(t.getDate().getBytes());
	}

}
