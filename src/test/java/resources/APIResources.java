package resources;
//enum is special class in java which has collection of constants or methods
//why use
// in normal class
//publi class apoiresir(){String sname="saikiran"  public String getname(){return sname}} instead of all these we can write enum
public enum APIResources {
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	//just we have to create constutor as eclips ei suggestion
	APIResources(String resource){
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}
