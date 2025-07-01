package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
public RequestSpecification requestspecification() throws IOException {
	//here why we are writing req==null {} return req means 
	//we are doing data with multiple data so in loggin.txt it will replace the first with secobnd so first ouput it wont show
	// so we are telling and we using public static requestspecifiaction req; as static beacuse first dtat will store like that 
	//only second data will add
	if(req==null) {
	PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
	//RestAssured.baseURI="https://rahulshettyacademy.com";
	
	req=new RequestSpecBuilder().setBaseUri(globalproperties()).addQueryParam("key","qaclick123")
			//here addfilter is used to log the logginf in file or anydata
			//so we have screated printstream new fileoutstream to print all the logging to uoutput in file as loggin.txt
			//we dobt to create a file it has capability to create it
			//it wikll print before it hittimg the request as it is request specifiaction right so
			.addFilter(RequestLoggingFilter.logRequestTo(log))
			//now i need respone alson thenb again we to add addfileter like below
			.addFilter(ResponseLoggingFilter.logResponseTo(log))
			//we route both response and request to logging only
			.setContentType(ContentType.JSON).build();
	return req;
	}
	return req;
}
public static String  globalproperties() throws IOException {
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\saikr\\eclipse-workspace\\Latest_API_Cucumber\\src\\test\\java\\resources\\global.properties");
	prop.load(fis);
return	prop.getProperty("baseUrl");
	
}

public String getJsonPath(Response response,String key) {
	String resp=response.asString();
	
	
	JsonPath js=new JsonPath(resp);
	return js.get(key).toString();
		
}
}
