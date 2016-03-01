package com.manh.ejb.stateless;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class DateBean implements Date 
{
	@Resource
	SessionContext sessionContext;
	
	@Override
	public String today() 
	{
		 StringBuffer date = new StringBuffer();
	     Calendar calendar = Calendar.getInstance();
	     date.append(calendar.get(Calendar.MONTH)+1);
	     date.append("/");
	     date.append(calendar.get(Calendar.DAY_OF_MONTH));
	     date.append("/");
	     date.append(calendar.get(Calendar.YEAR));
	     return date.toString();
	}

}
