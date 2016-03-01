package com.manh.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.BindingType;

@WebService(targetNamespace="http://www.sapient.com" ,name="AddNumbersService")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@SOAPBinding(style=Style.RPC,use=Use.LITERAL,parameterStyle=ParameterStyle.WRAPPED)
public interface IAddNumbersService 
{
	@WebMethod(operationName="add",action="urn:addNumber")
	@WebResult(name="returnValue",targetNamespace="http://www.sapient.com")
	public int addNumber(@WebParam(name="num1") int number1 , @WebParam(name="num2") int number2)throws AddNumbersException;
}
