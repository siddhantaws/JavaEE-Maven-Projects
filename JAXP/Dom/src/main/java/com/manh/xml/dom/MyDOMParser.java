package com.manh.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MyDOMParser 
{
	public static void main(String[] args) 
	{
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		builderFactory.setNamespaceAware(true);
		builderFactory.setIgnoringComments(false);
		builderFactory.setIgnoringElementContentWhitespace(false);
		builderFactory.setCoalescing(false);
		try {
			DocumentBuilder builder=builderFactory.newDocumentBuilder();
			builder.setErrorHandler(new MyContentHandler());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
