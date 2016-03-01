package com.manh.jaxb2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum SubElemType 
{
	@XmlEnumValue("USA")
	USA("usa") ,
	@XmlEnumValue("INDIA")
	INDAI("inda");
	private final String value;
	SubElemType(String value)
	{
		this.value=value;
	}
	public String value() {
        return value;
    }

}
