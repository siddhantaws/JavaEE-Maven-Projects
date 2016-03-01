package com.manh.helloworld;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.restfully.shop.domain.Customer;

public class FileDownloadClient 
{
	public static void main(String[] args) throws IOException 
	{
		Client client=ClientBuilder.newClient();
		//POST request
		WebTarget target=client.target("http://localhost:8080/jaxrs-2.0-filedownload/services/resources/getFile");
		InputStream response=target.request().accept("application/pdf").get(InputStream.class);
		//System.out.println(response.getHeaderString("Content-Disposition"));
		byte barray[]=new byte[response.available()];
		response.read(barray);
		FileOutputStream  stream=new FileOutputStream(new File("D://a.pdf"));
		stream.write(barray);
	}
}
