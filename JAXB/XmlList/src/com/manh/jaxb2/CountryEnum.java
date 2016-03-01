package com.manh.jaxb2;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name="CountryEnumType")
public class CountryEnum 
{
	public SubElemType elemType;

	public CountryEnum() {
		super();
	}
	
}
