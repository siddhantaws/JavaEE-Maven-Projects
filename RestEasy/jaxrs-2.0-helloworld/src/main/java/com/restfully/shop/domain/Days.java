package com.restfully.shop.domain;

public class Days 
{
	private String date;

	private String nextDate;
	
	
	public String getNextDate() {
		return nextDate;
	}

	public void setNextDate(String nextDate) {
		this.nextDate = nextDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Days(String date ,String nextDate) {
		super();
		this.date = date;
		this.nextDate=nextDate;
	}
	//public Days(String date){this.date=date;}
	public static Days valueOf(String date) 
	{
		return new Days(date, null);
	}
	@Override
	public String toString() 
	{
		return date.toString();
	}
}
