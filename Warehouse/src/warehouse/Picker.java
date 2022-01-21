package warehouse;

import java.util.ArrayList;
import java.util.List;

public class Picker {

	private List<Picker> pickerDetails = new ArrayList<Picker>();
	private String assignedShelves;  
	private String pickerName;
	//private String numberOfShevles;
	private String shelfNumbers;

	public Picker() {

	}

	public Picker(String name, String numberOfShevles, String shelfNumbers) {
		this.pickerName = name;
		this.assignedShelves = numberOfShevles;
		this.shelfNumbers = shelfNumbers;
	}

	public String getshelfNumbers() {
		return shelfNumbers;
	}

	public void setshelfNumbers(String shelfNumbers) {
		this.shelfNumbers = shelfNumbers;
	}

	// Another Constructor

	public void setPicker(List<Picker> pickerDetails) {
		this.pickerDetails = pickerDetails;
	}

	public List<Picker> pickerDetails() {
		return pickerDetails;
	}

	public void setname(String information) {
		this.pickerName = information;
	}

	public String getname() {
		return pickerName;
	}



	public List<Picker> getpickerDetails() {
		return pickerDetails;
	}

	public void setpickerDetails(List<Picker> pickerDetails) {
		this.pickerDetails = pickerDetails;
	}

	


	public String getpickerName() {
		return pickerName;
	}

	public void setpickerName(String pickerName) {
		this.pickerName = pickerName;
	}

	public String display() {
		return pickerName +  assignedShelves + shelfNumbers;

	}

	public String displayDetails(int i) {
		// TODO Auto-generated method stub
		return i + pickerName;
	}

	public void add(Picker picker) {
		// TODO Auto-generated method stub

	}

	public void details() {
		System.out.print("Please Enter the Keeper Details" + "\nPlease enter the name of the Picker: ");
		//setpickerName(Validate.validateString());
	}

	

	public String getassignedShelves() {
		// TODO Auto-generated method stub
		return null;
	}
}