package warehouse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Shelf {

	private String shelfNumber;
	private List<Driver> newDriver = new LinkedList<Driver>();
	private List<Picker> newPicker = new ArrayList<Picker>();
	private List<Shelf> numberOfShevles = new ArrayList<Shelf>();
	private int maxNumberOfPickers;
	private String catag;

	public Shelf(String catag, String number) {
		// TODO Auto-generated constructor stub
		this.shelfNumber = number;
		this.setCatag(catag);
	}

	public void setkeeper(Picker picker) {
		// TODO Auto-generated method stub
		// Keeper.details();
	}

	// ======================================================================
	public void setKeeperList(List<Picker> newPicker) {
		this.newPicker = newPicker;
	}

	// ======================================================================
	public String getshelfNumber() {
		return shelfNumber;
	}

	public List<Driver> getDriver() {
		return newDriver;
	}

	// ======================================================================
	public List<Picker> getPicker() {
		return newPicker;
	}

	public static void displayDetails() {

	}

	public void displayDetails(int i) {
		// TODO Auto-generated method stub

	}

	public void setMaxNumberOfPickers(int maxNumberOfPickers) {
		this.maxNumberOfPickers = maxNumberOfPickers;
	}

	public int getMaxNumberOfPickerss() {
		return maxNumberOfPickers;
	}

	public List<Shelf> getnumberOfShevles() {
		return numberOfShevles;
	}

	public void setnumberOfShevles(List<Shelf> numberOfShevles) {
		this.numberOfShevles = numberOfShevles;
	}

	public void addDriver() {
		Driver driver = new Driver();
		driver.details();
		newDriver.add(driver);
	}

	public String getCatag() {
		return catag;
	}

	public void setCatag(String catag) {
		this.catag = catag;
	}

	public static void get(int i) {
		// TODO Auto-generated method stub

	}

	public String display() {
		return shelfNumber + catag;

	}

	public void addKeeper() {
		// TODO Auto-generated method stub
		Picker picker = new Picker();
		picker.details();
		newPicker.add(picker);
	}

	public void setAvailableShelves(List<Shelf> numberOfShevles2) {
		// TODO Auto-generated method stub
		
	}
}
