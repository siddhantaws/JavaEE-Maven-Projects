package com.manh.jaxb2;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlType(name="EmployeeType")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee 
{
	@XmlID
	@XmlAttribute
	private String id;
	@XmlID
	@XmlAttribute
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlIDREF
	@javax.xml.bind.annotation.XmlElement
	private Employee manager;
	@XmlIDREF
	@javax.xml.bind.annotation.XmlElement
	private List<Employee> reportsmanager;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public List<Employee> getReportsmanager() {
		return reportsmanager;
	}
	public void setReportsmanager(List<Employee> reportsmanager) {
		this.reportsmanager = reportsmanager;
	}
	public Employee() {
		super();
	}
	
}
