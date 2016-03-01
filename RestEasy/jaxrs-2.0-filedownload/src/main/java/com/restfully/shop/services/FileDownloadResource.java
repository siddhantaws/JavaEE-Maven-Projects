package com.restfully.shop.services;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/resources")
public class FileDownloadResource 
{	
	private static final String FILE_PATH_PDF = "E:\\Maven-Project\\JAX-RS\\jaxrs_basics1.pdf";
	private static final String FILE_PATH_IMAGE = "E:\\Maven-Project\\JAX-RS\\1_example6.png";
	private static final String FILE_PATH_EXCEL = "E:\\Maven-Project\\JAX-RS\\excel-file.xls";
	@GET
	@Path("/getFile")
	@Produces("application/pdf")
	public Response getPDFFile() 
	{
		System.out.println(1);
 		File file = new File(FILE_PATH_PDF);
 		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=new-android-book.pdf");
		return response.build();
 
	}
	@GET
	@Path("/getFile")
	@Produces("image/png")
	public Response getIMAGEFile() 
	{
		File file = new File(FILE_PATH_IMAGE);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition","attachment; filename=image_from_server.png");
		return response.build();
 
	}
	@GET
	@Path("/getFile")
	@Produces("application/vnd.ms-excel")
	public Response getXSLFile() 
	{
 		File file = new File(FILE_PATH_EXCEL);
 		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=new-excel-file.xls");
		return response.build();
 
	}
}	
