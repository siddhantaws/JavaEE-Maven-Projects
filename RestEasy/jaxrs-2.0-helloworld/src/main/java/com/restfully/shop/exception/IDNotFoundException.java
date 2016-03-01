package com.restfully.shop.exception;

public class IDNotFoundException extends RuntimeException 
{
	private String id;
	@Override
	public String getMessage() 
	{
		return id+" Not Found ;";
	}
	public IDNotFoundException(String id)
	{
		this.id=id;
	}
}
