package com.manh.xml.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.HashMap;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

public class EventProducerConsumer 
{
	static XMLEventFactory  m_eventFactory = XMLEventFactory.newInstance();
	public static void main(String[] args) 
	{
		try {
		
			XMLEventReader eventReader=XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(new File("E:/Maven-Project/WebService/StAX/src/main/java/BookCatalog.xml")));
			XMLEventWriter eventWriter=XMLOutputFactory.newInstance().createXMLEventWriter(System.out);
			while (eventReader.hasNext()) 
			{
                XMLEvent event = (XMLEvent) eventReader.next();
                
                //write this event to Consumer (XMLOutputStream)
                if (event.getEventType() == event.CHARACTERS) 
                {
                    //character events where text "Name1" is replaced with text output 
                    //of following function call Calendar.getInstance().getTime().toString()
                	eventWriter.add(getNewCharactersEvent(event.asCharacters()));
                	
                } else {
                	eventWriter.add(event);
                }
            }
			eventWriter.flush();
		} catch (FileNotFoundException | XMLStreamException | FactoryConfigurationError e) 
			{
				e.printStackTrace();
			}
	}
	private static Characters getNewCharactersEvent(Characters event) 
	{
        if (event.getData().equalsIgnoreCase("The First and Last Freedom")) {
        
            return m_eventFactory.createCharacters(Calendar.getInstance().getTime().toString());
        } //else return the same event
        else {
            return event;
        }
    }
}
