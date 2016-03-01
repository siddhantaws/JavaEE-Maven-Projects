package com.manh.jaxb2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="purchaseOrder")
@XmlType(name="PurchaseOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseOrderType 
{
	public CreditCardVendor creditCardVendor;
    public USAddress billTo;
    public USAddress shipTo;
	public CreditCardVendor getCreditCardVendor() {
		return creditCardVendor;
	}
	public void setCreditCardVendor(CreditCardVendor creditCardVendor) {
		this.creditCardVendor = creditCardVendor;
	}
	public USAddress getBillTo() {
		return billTo;
	}
	public void setBillTo(USAddress billTo) {
		this.billTo = billTo;
	}
	public USAddress getShipTo() {
		return shipTo;
	}
	public void setShipTo(USAddress shipTo) {
		this.shipTo = shipTo;
	}
	 @Override
	 public String toString() 
	 {
		 StringBuilder s = new StringBuilder();
	     s.append("Ship To: ");
	     s.append(shipTo.toString()).append('\n');
	     s.append("Bill To: ");
	     return s.toString();
	  }
}
