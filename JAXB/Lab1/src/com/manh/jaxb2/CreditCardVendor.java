package com.manh.jaxb2;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ccv")
public enum CreditCardVendor 
{
	VISA,
    AMERICANEXPRESS,
    DISCOVER;
}
