package com.manh.jaxb2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class J2SXmlRootElement 
{
	public static void main(String[] args) 
	{
		 // A Ship to type
        USAddress shipto = new USAddress(
                    "Alice Smith",
                    "123 Maple Street",
                    "Mill Valley",
                    "CA",
                    90952);

        // A bill to type
        USAddress billto = new USAddress(
                    "Robert Smith",
                    "8 Oak Avenue",
                    "Old Town",
                    "PA",
                    95819);
        // A purchaseOrder
        PurchaseOrderType po = new PurchaseOrderType();
        po.billTo = billto;
        po.shipTo = shipto;
        po.creditCardVendor=CreditCardVendor.VISA;
        JAXBContext jc;
        Marshaller m;
		try {
			jc = JAXBContext.newInstance(PurchaseOrderType.class);
			m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    m.marshal(po, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
