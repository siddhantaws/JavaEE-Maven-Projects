package com.manh.jaxb2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;

import org.w3c.dom.Document;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class DisplaySchema 
{
	public static void displaySchema(JAXBContext context)
	{
		List<DOMResult>  domResults=new ArrayList<DOMResult>();
		SchemaOutputResolver outputResolver=new SchemaOutputResolver()
		{
			@Override
			public Result createOutput(String namespaceUri,String suggestedFileName) throws IOException 
			{
				DOMResult result=new DOMResult();
				result.setSystemId(suggestedFileName);
				domResults.add(result);
				return result;
			}
		};
		try {
			context.generateSchema(outputResolver);
			DOMResult domResult;
            Document doc;
            OutputFormat format;
            XMLSerializer serializer;
            for (int i = 0; i < domResults.size(); i++) {
                System.out.println("-------------------Schema number " +
                        (i + 1));
                domResult = domResults.get(i);
                doc = (Document) domResult.getNode();
                format = new OutputFormat(doc);
                format.setIndenting(true);
                serializer = new XMLSerializer(System.out, format);
                serializer.serialize(doc);
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
