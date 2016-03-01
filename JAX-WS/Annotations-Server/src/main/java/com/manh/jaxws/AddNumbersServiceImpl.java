package com.manh.jaxws;

import javax.jws.WebService;

@WebService(endpointInterface="com.manh.jaxws.IAddNumbersService")
public class AddNumbersServiceImpl implements IAddNumbersService{

	
	@Override
	public int addNumber(int number1, int number2)throws AddNumbersException {
		if (number1 < 0 || number2 < 0) {
            throw new AddNumbersException("Negative number cant be added!",
                            "Numbers: " + number1 + ", " + number2);
    }
    return number1 + number2;
	}

}
