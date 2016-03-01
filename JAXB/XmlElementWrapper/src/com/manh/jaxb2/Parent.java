package com.manh.jaxb2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name="Parent")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name="ParentType")
public class Parent
{
	@XmlElementWrapper(name = "items", required = true)
    @XmlElement(name = "item")
	public List<String> items;
	
	public List<String> getItems() 
	{
		if (items == null) {
            items = new ArrayList<String>();
        }
        return items;
	}


	public void setItems(List<String> items) {
		this.items = items;
	}


	public Parent() 
	{
		super();
		
	}
	
}
