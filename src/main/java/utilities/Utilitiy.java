package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utilitiy {
	public static RequestSpecification request;
	Properties property;
	
	public RequestSpecification requestSpecifcation() throws IOException
	{
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		request = new RequestSpecBuilder().setBaseUri(getGlobalProperty("baseURI"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return request;
	}
	
	public String getGlobalProperty(String key) throws IOException
	{	
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\globalResources\\Global.properties";
		property = new Properties();
		FileInputStream fis = new FileInputStream(path);
		property.load(fis);
		return property.getProperty(key);
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = property.getProperty("extentReportConfig");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
}
