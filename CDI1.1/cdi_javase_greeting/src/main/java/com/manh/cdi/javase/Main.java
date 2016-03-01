package com.manh.cdi.javase;

import org.cdisource.beancontainer.BeanContainer;
import org.cdisource.beancontainer.BeanContainerManager;

public class Main 
{
	public static void main(String[] args)
	{
		BeanContainer beanContainer=BeanContainerManager.getInstance();
		Greeting  greeting=(Greeting)beanContainer.getBeanByName("greeting");
		System.out.println(greeting.greet("Siddhanta"));
	}
}
