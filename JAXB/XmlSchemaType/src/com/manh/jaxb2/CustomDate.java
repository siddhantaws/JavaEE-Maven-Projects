package com.manh.jaxb2;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomDate 
{
	public CustomDate(Date date) {
		super();
		this.date = date;
	}
	public Date date;
	public Date getDate()
	{
		return date;
	}
	
}
