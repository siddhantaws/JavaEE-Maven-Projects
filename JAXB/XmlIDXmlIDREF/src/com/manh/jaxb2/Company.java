package com.manh.jaxb2;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name="CompanyType")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company 
{
	@XmlElement
	public List<Employee> employees;

	public Company() 
	{
		super();
	}
}
