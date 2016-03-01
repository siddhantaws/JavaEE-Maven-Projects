package com.manh.xml.sax;

import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

public class MyLexicalHandler implements LexicalHandler {

	@Override
	public void startDTD(String name, String publicId, String systemId)throws SAXException 
	{
		System.out.println("XML Document startDTD");
		System.out.println("XML Document startDTD");
	}

	@Override
	public void endDTD() throws SAXException 
	{
		System.out.println("XML Document endDTD");
		System.out.println("XML Document endDTD");
	}

	@Override
	public void startEntity(String name) throws SAXException 
	{
		System.out.println("XML Document startEntity");
		System.out.println("XML Document startEntity");
	}

	@Override
	public void endEntity(String name) throws SAXException 
	{
		System.out.println("XML Document endEntity");
		System.out.println("XML Document endEntity");
	}

	@Override
	public void startCDATA() throws SAXException 
	{
		System.out.println("XML Document startCDATA");
		System.out.println("XML Document startCDATA");
	}

	@Override
	public void endCDATA() throws SAXException 
	{
		System.out.println("XML Document endCDATA");
		System.out.println("XML Document endCDATA");
	}

	@Override
	public void comment(char[] ch, int start, int length) throws SAXException 
	{
		System.out.println("XML Document comment");
		System.out.println(new String(ch, start,length));
		System.out.println("XML Document comment");
	}

}
