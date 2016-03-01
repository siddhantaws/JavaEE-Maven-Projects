package com.restfully.shop.exception.mapper;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.restfully.shop.exception.IDNotFoundException;

@Provider
public class IDNotFoundExceptionMapper implements ExceptionMapper<IDNotFoundException>
{
	@Override
	public Response toResponse(IDNotFoundException exception) 
	{
		return Response.status(Status.INTERNAL_SERVER_ERROR).header("x-reason", exception.getMessage()).build();
	}

}
