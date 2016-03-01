package com.manh.jaxb2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlType(name="ParagraphType")
public class Paragraph 
{
	@javax.xml.bind.annotation.XmlElement
	@XmlList
	public List<Sentence> sentence;

	public Paragraph() {
		super();
		sentence=new ArrayList<Sentence>();
	}
	
}
