package com.manh.jaxb2;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="purchaseOrder")
@XmlType(name="PurchaseOrderType")
public class PurchaseOrderType 
{
	public USAddress billTo;
    public USAddress shipTo;
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Ship To: ");
        s.append(shipTo.toString())
         .append('\n');
        s.append("Bill To: ");
        s.append(billTo.toString())
         .append('\n');

        return s.toString();
    }
}
