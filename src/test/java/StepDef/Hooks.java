package StepDef;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeSceanrio() throws IOException {
		//execute this code when place id is null
		//write a code that will give you place id
		
		steps step=new steps();
		//here why we are calling with classname.placeid insted of objectname step.palce id 
		//beacuse static members can call using class name here place id is static 
		//so we can use bbject name but best is class name
		if(steps.place_id==null) {
		step.add_place_payload("shetty","french", "hyd");
		step.user_calls_with_http_request("AddPlaceAPI","Post");
		step.verify_place_id_created_maps_to_using("shetty","getPlaceAPI");
	}
		}

}
