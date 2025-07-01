package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace_serilaztion;
import Pojo.Location;

public class TestDataBuild {
	public AddPlace_serilaztion addPlacePayLoad(String name,String lan,String address) {
	AddPlace_serilaztion addplace=new AddPlace_serilaztion();
			addplace.setAccuracy(50);
			addplace.setAddress(address);
			addplace.setWebsite("http://google.com");
			addplace.setLanguage(lan);
			addplace.setPhone_number("(+91) 983 893 3937");
			addplace.setName(name);
			List<String> mylist=new ArrayList<>();
			mylist.add("shoe park");
			mylist.add("shop");
			addplace.setTypes(mylist);
			Location l=new Location();
			l.setLat(-38.383494);
			l.setLng(33.427362);
			addplace.setLocation(l);
			return addplace;
	}
public String deletePlacePayLoad(String placeid) {
	return "{ \"place_id\": \"" + placeid + "\" }";
}
}
