package com.manh.jaxb2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name="ShirtsType")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shirts 
{
	@XmlElement
	public Price price;

	public Shirts() {
		super();
	}
	
}
