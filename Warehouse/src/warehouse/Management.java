package warehouse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Management {

	private List<Picker> picker = new LinkedList<Picker>();
	private List<Driver> driver = new LinkedList<Driver>();
	private List<Shelf> numberOfShevles = new ArrayList<Shelf>();

	public Management(String name) {
	//constructorr
	}

	public List<Picker> getpicker() {
		return picker;
	}

	public void setKeeper(List<Picker> picker) {
		this.picker = picker;
	}

	public List<Driver> getDriver() {
		return driver;
	}

	public void setDriver(List<Driver> driver) {
		this.driver = driver;
	}

	public void addPicker() {
		Picker mypicker = new Picker();
		((Picker) mypicker).pickerDetails();
		picker.add(mypicker);
	}

	public void addAnimal() {
		Driver mydriver = new Driver();
		mydriver.details();
		driver.add(mydriver);
	}

	public String displayDetails() {
		System.out.println();

		String results = "";
		for (int i = 0; i < getpicker().size(); i++) {
			results = results + getpicker().get(i).displayDetails((i + 1));
		}
		for (int i = 0; i < getDriver().size(); i++) {
			results = results + getDriver().get(i).displayDetails((i + 1));
		}
		return results;
	}

	public List<Shelf> getnumberOfShevles() {
		return numberOfShevles;
	}

	public void setnumberOfShevles(List<Shelf> numberOfShevles) {
		this.numberOfShevles = numberOfShevles;
	}
}
