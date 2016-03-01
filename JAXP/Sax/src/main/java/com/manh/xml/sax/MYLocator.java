package com.manh.xml.sax;

import org.xml.sax.Locator;

public class MYLocator implements Locator
{

	@Override
	public String getPublicId() 
	{
		return null;
	}

	@Override
	public String getSystemId() 
	{
		return null;
	}

	@Override
	public int getLineNumber() 
	{
		return 0;
	}

	@Override
	public int getColumnNumber() 
	{
		return 0;
	}

}
