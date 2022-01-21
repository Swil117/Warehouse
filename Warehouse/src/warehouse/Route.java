package warehouse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Route {
	
	private String areaID;
	private List<Shelf> shelves = new ArrayList<Shelf>();
	private List<Picker> pickerDet = new ArrayList<Picker>();
	private String suitability;
	private int numberOfShevles; 
	private int maxNumberOfPickers; 
	private List<Route> routeNo = new LinkedList<Route>();

	// Constructor
	public Route(String string, String string2, String string3) {
		// Nothing here, evidently.
	}

	// Another Constructor
	public Route(String suitability, int numberOfShelves, int maxNumberOfPickers) {
		// TODO Auto-generated constructor stub
		this.numberOfShevles = numberOfShelves;
		this.suitability = suitability;
		this.maxNumberOfPickers = maxNumberOfPickers;
	}

	// Another Constructor
	public Route(String suitability) {
		// TODO Auto-generated constructor stub
		this.suitability = suitability;
		this.numberOfShevles = numberOfShevles;
	}

	public void setareaID(String categoryID) {
		this.areaID = categoryID;
	}

	public String getareaID() {
		return areaID;
	}

	public void setAvailableCages(List<Shelf> shelves) {
		this.shelves = shelves;
	}

	public List<Shelf> getshelves() {
		return shelves;
	}

	public void setSuitability(String information) {
		this.suitability = information;
	}

	public String getSuitability() {
		return suitability;
	}

	public void setnumberOfShevles(int numberOfShevles) {
		this.numberOfShevles = numberOfShevles;
	}

	public int getnumberOfShevles() {
		return numberOfShevles;
	}

	public void setmaxNumberOfPickers(int maxNumberOfPickers) {
		this.maxNumberOfPickers = maxNumberOfPickers;
	}

	public int getmaxNumberOfPickers() {
		return maxNumberOfPickers;
	}

	public List<Picker> getpickerDet() {
		return pickerDet;
	}

	public void setKeeperDet(List<Picker> pickerDet) {
		this.pickerDet = pickerDet;
	}

	public List<Route> getRouteNo() {
		return routeNo;
	}

	public void setRouteNo(List<Route> routeNo) {
		this.routeNo = routeNo;
	}

	public void addDriver() {
		// TODO Auto-generated method stub
		
	}

	public static void add(Route populateRouteDetails) {
		// TODO Auto-generated method stub
		
	}

	public static Route get(int count) {
		// TODO Auto-generated method stub
		return null;
	}


}