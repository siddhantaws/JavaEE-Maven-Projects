package com.manh.xml.stax;

import java.awt.Event;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class StAXParser 
{
	public static void main(String[] args) 
	{
		try {
			XMLInputFactory inputFactory=XMLInputFactory.newFactory();
			XMLStreamReader xmlStreamReader=inputFactory.createXMLStreamReader(new FileInputStream(new File("E:/Maven-Project/WebService/sax/src/main/java/applicationContext.xml")));
			while(xmlStreamReader.hasNext())
			{
				switch(xmlStreamReader.next())
				{
					case XMLEvent.START_ELEMENT :
						printStartElement(xmlStreamReader);
						/*	case XMLEvent.END_ELEMENT :
						printEndElement(xmlStreamReader);
					case XMLEvent.CHARACTERS :	
						printCHARACTERS(xmlStreamReader);*/
					
				}
					
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void printATTRIBUTE(XMLStreamReader xmlr) 
	{

		System.out.println(xmlr.getAttributeCount());
		for(int i=0;i<xmlr.getAttributeCount();i++)
		{
			System.out.println(xmlr.getAttributeLocalName(i));
			System.out.println(xmlr.getAttributeNamespace(i));
			System.out.println(xmlr.getAttributePrefix(i));
			System.out.println(xmlr.getAttributeType(i));
			System.out.println(xmlr.getAttributeValue(i));
		}
	}
	private static void printCHARACTERS(XMLStreamReader xmlr) 
	{
		System.out.println(xmlr.getEncoding());
		System.out.println(xmlr.getNamespaceURI());
		System.out.println(xmlr.getPrefix());
		System.out.println(xmlr.getLocation());
		try {
			System.out.println(xmlr.getElementText());
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void printStartElement(XMLStreamReader xmlr) 
	{
		
		System.out.println(xmlr.getEncoding());
		System.out.println(xmlr.getLocalName());
		System.out.println(xmlr.getNamespaceCount());
		System.out.println(xmlr.getNamespaceURI());
		System.out.println(xmlr.getPrefix());
		System.out.println(xmlr.getLocation());
		System.out.println(xmlr.getName());
		System.out.println(xmlr.getVersion());
		printATTRIBUTE(xmlr) ;
	}  
	private static void printEndElement(XMLStreamReader xmlr) 
	{
		
		System.out.println(xmlr.getEncoding());
		System.out.println(xmlr.getLocalName());
		System.out.println(xmlr.getNamespaceCount());
		System.out.println(xmlr.getNamespaceURI());
		System.out.println(xmlr.getPrefix());
		System.out.println(xmlr.getLocation());
		System.out.println(xmlr.getName());
		System.out.println(xmlr.getVersion());
	}
}
