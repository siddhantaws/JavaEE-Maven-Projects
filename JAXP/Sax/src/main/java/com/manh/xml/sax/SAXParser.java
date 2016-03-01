package com.manh.xml.sax;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXParser 
{
	public static void main(String[] args) 
	{
		try {
			
			XMLReader xmlReader=XMLReaderFactory.createXMLReader();
			MyContentHandler contentHandler=new MyContentHandler();
			contentHandler.setDocumentLocator(new MYLocator());
			xmlReader.setContentHandler(contentHandler);
			xmlReader.setErrorHandler(contentHandler);
			xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", new MyLexicalHandler()); 
			xmlReader.setFeature("http://apache.org/xml/features/validation/schema", true);
			try {
				xmlReader.parse("file:E:/Maven-Project/WebService/sax/src/main/java/applicationContext.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
