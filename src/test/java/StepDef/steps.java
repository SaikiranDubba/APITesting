package StepDef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace_serilaztion;
import Pojo.Location;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class steps extends Utils {

	ResponseSpecification responspec;
Response response;
RequestSpecification res;
static String place_id;


	TestDataBuild data=new TestDataBuild();
	


@Given("Add Place Payload {string} {string} {string}")
public void add_place_payload(String name, String lan, String address) throws IOException {
    


//	.then()
//	.spec(responspec).extract().response();
		
	
		
 responspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
res=given().spec(requestspecification()).body(data.addPlacePayLoad(name,lan,address));
	    
	}
	@When("user calls  {string} with {string} http  request")
	public void user_calls_with_http_request(String resource,String httpmethod) throws IOException {
		//.valueof taking the value from enum 
		//constructor will be called with value of resource which you pass 
		
	APIResources resourceAPI=APIResources.valueOf(resource);
	System.out.println(resourceAPI.getResource());
	if(httpmethod.equalsIgnoreCase("POST")) {
		 response=res.when().post(resourceAPI.getResource());
	}else if(httpmethod.equalsIgnoreCase("GET"))
	{
		response=res.when().get(resourceAPI.getResource());
	}
	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		response.then().log().all();
		assertEquals(response.getStatusCode(),200);

	

		
	}
	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String expectedvalue) {
	
		
		assertEquals(getJsonPath(response,keyvalue),expectedvalue);
	


	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {
		 System.out.println("Response before extracting place_id: " + response.asString());
		 place_id=getJsonPath(response,"place_id");
		System.out.println(place_id);
		res =given().spec(requestspecification()).queryParam("place_id",place_id);
		user_calls_with_http_request(resource,"GET");
	
		String actualname=getJsonPath(response,"name");
		
		assertEquals(actualname,expectedname);
	}

@Given("DeletePlace Payload")
public void delete_place_payload() throws IOException {
	res=given().spec(requestspecification()).body(data.deletePlacePayLoad(place_id));

}




}
