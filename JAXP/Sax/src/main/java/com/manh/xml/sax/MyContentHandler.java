package com.manh.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MyContentHandler extends DefaultHandler
{
	private Locator locator;
	
	public void setLocator(Locator locator) 
	{
		this.locator = locator;
	}
	@Override
	public void startDocument() throws SAXException 
	{
		System.out.println("XML Document START");
	}
	@Override
	public void endDocument() throws SAXException 
	{
		System.out.println("XML Document END");
	}
	@Override
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException 
	{
		System.out.println("Start Document startElement");
		System.out.println("uri->"+uri);
		System.out.println("localName->"+localName);
		System.out.println("qName->"+qName);
		
		System.out.println("END Document startElement");
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)throws SAXException 
	{
		System.out.println("XML Document endElement");
		System.out.println("uri->"+uri);
		System.out.println("localName->"+localName);
		System.out.println("qName->"+qName);
		System.out.println("END Document endElement");
	}
	@Override
	public void processingInstruction(String target, String data)throws SAXException 
	{
		System.out.println("XML processingInstruction start");
		System.out.println("target->"+target+"data->"+data);
		System.out.println("XML processingInstruction end");
	}
	@Override
	public void characters(char[] ch, int start, int length)throws SAXException 
	{
		System.out.println("XML characters start");
		System.out.println(ch);	
		System.out.println("XML characters end");
	}
	
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)throws SAXException 
	{
		System.out.println("XML ignorableWhitespace start");
		System.out.println(ch);	
		System.out.println("XML ignorableWhitespace end");
	}
	
	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException 
	{
		System.out.println("XML startPrefixMapping start");
		System.out.println("prefix->"+prefix+"uri->"+uri);	
		System.out.println("XML startPrefixMapping end");
	}
	@Override
	public void error(SAXParseException e) throws SAXException 
	{
		System.out.println("XML error start");
		System.out.println("Exception :"+e);	
		System.out.println("Line Number"+locator.getLineNumber()+" Column Number"+locator.getColumnNumber());	
		System.out.println("XML error end");
	}
	@Override
	public void warning(SAXParseException e) throws SAXException 
	{
		System.out.println("XML warning start");
		System.out.println("warning :"+e);
		System.out.println("Line Number"+locator.getLineNumber()+" Column Number"+locator.getColumnNumber());	
		System.out.println("XML warning end");
	}
	@Override
	public void fatalError(SAXParseException e) throws SAXException 
	{
		System.out.println("XML fatalError start");
		System.out.println("fatalError :"+e);	
		System.out.println("Line Number"+locator.getLineNumber()+" Column Number"+locator.getColumnNumber());	
		System.out.println("XML fatalError end");
	}
	
}
