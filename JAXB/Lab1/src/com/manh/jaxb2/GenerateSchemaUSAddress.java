package com.manh.jaxb2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class GenerateSchemaUSAddress 
{
	public static void main(String[] args) 
	{
		try {
			JAXBContext context=JAXBContext.newInstance(PurchaseOrderType.class);
			DisplaySchema.displaySchema(context);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
