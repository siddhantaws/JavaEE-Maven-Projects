package com.manh.jaxb2;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://jaxb2.manh.com")
public class USAddress 
{
	  private String city;
	  private String name;
	  private String state;
	  private String street;
	  private int zip;
	  public USAddress()
	  {
		  
	  }
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public USAddress(String city, String name, String state, String street,
			int zip) {
		super();
		this.city = city;
		this.name = name;
		this.state = state;
		this.street = street;
		this.zip = zip;
	}
}
