package com.manh.jaxb2;

public class USAddressFactory
{
	public static USAddress getUSAddress()
	{
		return new USAddress(
                "Dummy Name",
                "Dummy Street",
                "Dummy City",
                "XX",
                90952);
	}
}
