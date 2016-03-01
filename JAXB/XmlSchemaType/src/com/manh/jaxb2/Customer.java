package com.manh.jaxb2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlType(name="CustomerType")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer 
{
	@XmlElement
	@XmlSchemaType(name="date")
	@XmlJavaTypeAdapter(CustomDate2Date.class)
	public CustomDate date;

	public Customer() {
		super();
	}
	
}
