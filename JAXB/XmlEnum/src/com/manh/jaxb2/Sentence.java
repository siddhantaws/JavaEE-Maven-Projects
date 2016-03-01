package com.manh.jaxb2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(name="SentenceType")
public class Sentence 
{
	@javax.xml.bind.annotation.XmlElement
	@XmlList
	public List<String> word;

	public Sentence() {
		super();
		word=new ArrayList<String>();
	}
	
}
