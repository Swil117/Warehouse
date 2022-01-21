package warehouse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Menu extends warehouseMain {
	List<Picker> pickerDetails = new ArrayList<Picker>();
	List<Driver> driverDet = new ArrayList<Driver>();
	List<Shelf> numberOfShevles = new ArrayList<Shelf>();
	List<Route> routeNo = new LinkedList<Route>();
	String path = "Data Files\\";
	String nameOfFile = "DriverInformation.txt";
	BufferedReader in = Validate.checkFile(path + nameOfFile);
	String str;
	int count = 0;

	{ // used as an index for creating objects
		String path = "Data Files\\";
		String nameOfFile = "ShelfInformation.txt";
		BufferedReader in = Validate.checkFile(path + nameOfFile);
		String str;
		int count = 0; // used as an index for creating objects
		try {
			while ((str = in.readLine()) != null)// exit the loop only when
													// there are no more lines
			{

				numberOfShevles.add(populateShelfDetail(str));
				numberOfShevles.get(count).setAvailableShelves(numberOfShevles);
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	{
		try {
			while ((str = in.readLine()) != null)// exit the loop only when
													// there are no more lines
			{

				driverDet.add(populateDriverDetails(str));
				driverDet.get(count).setDriver(str);
				;
				count++;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String path = "Data Files\\";
		String nameOfFile = "PickerInformation.txt";
		BufferedReader in = Validate.checkFile(path + nameOfFile);
		String str;
		int count = 0; // used as an index for creating objects
		try {
			while ((str = in.readLine()) != null)// exit the loop only when
													// there are no more lines
			{

				pickerDetails.add(populatePickerDetails(str));
				pickerDetails.get(count).setname("");
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Constructor
	public Menu() {

	}

	

	public void display(List<Route> availableRoutes) throws IOException {
		int choice = 0;
		
		while (choice != 11) {
			System.out.println("\n****************MENU**********************");
			System.out.println("1- List Aviable Routes)");
			System.out.println("2- List information about specific Shelves");
			System.out.println("3- List all Available Shevles");
			System.out.println("4- List Available Pickers");
			System.out.println("5- List Category of Delivery");
			System.out.println("6- List Worker Details ");
			System.out.println("7- Add Driver to Route");
			System.out.println("8- Remove Driver from Route");
			System.out.println("9- Assign (Allocate) a Picker to a shelf area");
			System.out.println("10- Unassign a Picker from a shelf area ");
			System.out.println("11- Exit and Save all current details");
			System.out.println("***********************************");

			System.out.print("Please select from the above options: ");
			choice = Validate.validateInteger();

		
			choiceProcessing(choice, availableRoutes, numberOfShevles);
		}
		// return choice;
	}

	private void choiceProcessing(int choice, List<Route> availableRoutes, List<Shelf> shelveselection) throws IOException {
		// ===================================choice=1===================================
		
		if (choice == 1)//
		{
		
			System.out.println("\nThere are " + availableRoutes.size()
					+ " area of Routes available at Clyde Warehouse\n");
			for (int i = 0; i < availableRoutes.size(); i++) {
				System.out.println(
						"\n\t\t=========Area " + (i + 1) + " is: " + availableRoutes.get(i).getareaID());
			}

		}
		// ===================================choice=2===================================

		if (choice == 2)
		
		{

			String anotherRoute = "yes";
			do {
				
				int selection = routePlanning(availableRoutes);
				
				System.out.println("\n============Route Information for "
						+ availableRoutes.get(selection - 1).getareaID());
				System.out.print("\n Area ID:  " + availableRoutes.get(selection - 1).getareaID()
						+ "\n Areas within this are:\n"
						+ availableRoutes.get(selection - 1).getSuitability() + "\n" + "This area has "
						+ availableRoutes.get(selection - 1).getnumberOfShevles() + " shelves\n"
						+ "The maximum number of pickers per shelf area in this category: "
						+ availableRoutes.get(selection - 1).getmaxNumberOfPickers() + "\n");
				System.out.print("\nWould you like to see information about another area? (Yes/No):");
				anotherRoute = Validate.validateString();
			} while (anotherRoute.equals("YES".toLowerCase()) || anotherRoute.equals("Y".toLowerCase()));

		}

		if (choice == 3)// ===List Available Shelves===
		{
			String anotherRoute = "yes";
			do {

				int selection = shelveselection(numberOfShevles);
				System.out.print(
						"This area has " + numberOfShevles.get(selection - 1).getnumberOfShevles() + " shelves\n");

				System.out.print("\nWould you like to see information about another area? (Yes/No):");
				anotherRoute = Validate.validateString();
			} while (numberOfShevles.equals("YES".toLowerCase()) || numberOfShevles.equals("Y".toLowerCase()));

		}

		if (choice == 4) {

			// loops through the list and collects the data stated - picker name
			// etc
			for (int i = 0; i < pickerDetails.size(); i++) {
				System.out.println("Picker " + (i + 1) + " is " + pickerDetails.get(i).getname() + pickerDetails.get(i).getpickerName());
			}

		}
		if (choice == 5) {

			// loops through the list and collects the data stated - driver type
			// etc
			for (int i = 0; i < driverDet.size(); i++) {
				System.out.println("Delivery Type " + (i + 1) + " is " + driverDet.get(i).getDeliveryType());
			}

		}
		if (choice == 6) {
			// displays all driver information
			for (int i = 0; i < driverDet.size(); i++) {
				System.out.println((i + 1) + " " + driverDet.get(i).display());
			} // displays relevant picker information
			for (int i = 0; i < driverDet.size(); i++) {
				System.out.println(driverDet.get(i).getVehicleID() + " is assigned to Vehicle "
						+ driverDet.get(i) + " ");
			}
		}
		if (choice == 7) {
			int selection = shelveselection(numberOfShevles);

			System.out.println(("=================Adding Picker to "
					+ numberOfShevles.get(selection - 1).getshelfNumber() + "=============="));

			String addAnother;
			do 
			{
				numberOfShevles.get(selection - 1).addDriver();

				System.out.println("Would you like to add another Driver [Yes/No]");
				addAnother = (Validate.validateString()).toLowerCase();
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("DriverInformation.txt"))) {
					for (Driver line : driverDet) {
						bw.write(line + "\n");
					}
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (addAnother.equals("yes".toLowerCase()));
		}

		if (choice == 8) {

			int selection = shelveselection(numberOfShevles);

			if (numberOfShevles.get(selection - 1).getDriver().isEmpty()) {
				System.out.println("Sorry this route has no Drivers");
			} else {
				String addAnother;
				do {

					if (numberOfShevles.get(selection - 1).getDriver().isEmpty()) {
						System.out.println("Sorry this route has no Drivers");
						break;
					} else {
						System.out.println(
								"Drivers registered for " + numberOfShevles.get(selection - 1).getDriver() + " are:\n");

						for (int i = 0; i < numberOfShevles.get(selection - 1).getDriver().size(); i++) {
							System.out.println((i + 1) + "-"
									+ numberOfShevles.get(selection - 1).getDriver().get(i).getDriverName());
						}

						System.out.print("Please enter the name of Driver to be removed: ");
						String nameToBeRemoved = Validate.validateString();

						int index = indexProcessing(numberOfShevles.get(selection - 1).getDriver(), nameToBeRemoved);

						try {
							String name = numberOfShevles.get(selection - 1).getDriver().get(index).getDriverName();

							numberOfShevles.get(selection - 1).getDriver().remove(index);

							System.out.println("" + name + " is now removed");
						} catch (Exception e) {
							System.out.println("Sorry the Driver " + nameToBeRemoved + " is not registered in the "
									+ numberOfShevles.get(selection - 1).getshelfNumber() + "");
						}
						System.out.println("Would you like to remove another Driver [Yes/No]");
						addAnother = (Validate.validateString()).toLowerCase();
					}
				} while (addAnother.equals("yes".toLowerCase()));
			}
		}
		if (choice == 9) {
			int selection = shelveselection(numberOfShevles);

			System.out.println(("=================Adding a Picker to "
					+ numberOfShevles.get(selection - 1).getshelfNumber() + "=============="));

			String addAnother;
			do // do loop to prompt the user if or not another driver is to be
				// added to the
				// route
			{
				availableRoutes.get(selection - 1).addDriver();

				System.out.println("Would you like to add another Picker [Yes/No]");
				addAnother = (Validate.validateString()).toLowerCase();
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("PickerInformation.txt"))) {
					for (Driver line : driverDet) {
						bw.write(line + "\n");
					}
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (addAnother.equals("yes".toLowerCase()));
		}

		if (choice == 10) {
			int selection = routeSelection(availableRoutes);

			if (numberOfShevles.get(selection - 1).getPicker().isEmpty()) {
				System.out.println("Sorry this Shelf has no Picker");
			} else {
				String addAnother;
				do {

					if (numberOfShevles.get(selection - 1).getPicker().isEmpty()) {
						System.out.println("Sorry this cage has no Picker");
						break;
					} else {
						System.out.println(
								"Pickers registered for " + numberOfShevles.get(selection - 1).getPicker() + " are:\n");

						for (int i = 0; i < numberOfShevles.get(selection - 1).getPicker().size(); i++) {
							System.out.println(
									(i + 1) + "-" + numberOfShevles.get(selection - 1).getPicker().get(i).getname());
						}

						System.out.print("Please enter the name of Picker to be removed: ");
						String nameToBeRemoved = Validate.validateString();

						int index = indexprocessing(availableRoutes.get(selection - 1).getpickerDet(), nameToBeRemoved);

						try {
							String name = numberOfShevles.get(selection - 1).getPicker().get(index).getname();

							numberOfShevles.get(selection - 1).getPicker().remove(index);

							System.out.println("" + name + " is now removed");
						} catch (Exception e) {
							System.out.println("Sorry the Picker " + nameToBeRemoved + " is not registered in the "
									+ numberOfShevles.get(selection - 1).getshelfNumber() + "");
						}
						System.out.println("Would you like to remove another Picker [Yes/No]");
						addAnother = (Validate.validateString()).toLowerCase();
					}
				} while (addAnother.equals("yes".toLowerCase()));
			}

		}
		// =Exit Menu=
		else if (choice == 11) {

			System.out.println("Thank you and Bye");
			System.out.close();
			// System.exit(0);
		}
	}



	

	private int routePlanning(List<Route> availableRoutes) {
	
		return 0;
	}

	// =====================================================================================================================

	private int assignRoute(List<Route> availableRoutes) {
		// TODO Auto-generated method stub
		return 0;
	}

	// This method returns which route was selected
	private int routeSelection(List<Route> availableRoutes) {
		System.out.println("\nHere are the " + availableRoutes.size()
				+ " Shelves categories available to choose from, select [1-" + availableRoutes.size() + "]");
		String routeIndexes = "";
		// Create a string of the format "Please select the Enclosure
		// required[1, 2, 3,
		// 4, ...]:"
		// based on the number of elements in the availableEnclosure list

		routeIndexes = routeIndexes + numberOfAvailableRoutes(availableRoutes);
		int selection = 0;

		// keep on prompting the user to enter an enclosure number until the
		// correct
		// index is entered
		do {
			System.out.print("\nPlease select the shelf required [" + routeIndexes + "], select [1-"
					+ availableRoutes.size() + "]: ");
			selection = Validate.validateInteger();

			// if the wrong index is selected print an error message
			if (selection < 1 || selection > (availableRoutes.size())) {
				System.out.print("\nWhoops****\nThis is not a valid choice, please try again\n\n");
			}
		} while (selection < 1 || selection > (availableRoutes.size()));

		return selection;
	}


	// =====================================================================================================================

	private String numberOfAvailableRoutes(List<Route> availableRoutes) {
		String routeIndexes = "";
		for (int i = 0; i < availableRoutes.size(); i++) {
			if (i == (availableRoutes.size()) - 1) {
				routeIndexes = routeIndexes + Integer.toString(i + 1);
			} else {
				routeIndexes = routeIndexes + Integer.toString(i + 1) + ", ";
			}

			System.out.println("Route " + (i + 1) + " is : " + availableRoutes.get(i).getareaID() + "["
					+ (i + 1) + "]\n");
			
		}
		return routeIndexes;// returns the String
	}

	// This segment uses the file read above the menu to populate the picker
	// collection
	private Picker populatePickerDetails(String line) {
		String[] data;
		if (line == null) {
			return null;
		} else {
			// the content, line.split(",") returns a list[] of strings
			// separated by a tab
			data = line.split(",");
			return new Picker();
		}
	}

	private String pickerDetails(List<Picker> pickerDet) {
		String pickerDetails = "";
		for (int i = 0; i < pickerDet.size(); i++) {
			if (i == (pickerDet.size()) - 1) {
				pickerDetails = pickerDetails + Integer.toString(i + 1);
			} else {
				pickerDetails = pickerDetails + Integer.toString(i + 1) + ", ";
			}
			// This calls all the data in the list so it can be displayed as a
			// whole
			System.out.println("Picker " + (i + 1) + " is : " + pickerDet.get(i).display() + "[" + (i + 1) + "]\n");

		}
		return pickerDetails;// returns the String
	}

	// This segment uses the file read above the menu to populate the driver
	// collection
	private Driver populateDriverDetails(String line) {
		String[] data;
		if (line == null) {
			return null;
		} else {
			// the content, line.split(",") returns a list[] of strings
			// separated by a tab
			data = line.split(",");
			return new Driver(data[0].toUpperCase(), data[1].toUpperCase(), data[2].toUpperCase());
		}
	}

	private String driverDetails(List<Driver> driverDet) {
		String driverDetails = "";
		for (int i = 0; i < driverDet.size(); i++) {
			if (i == (driverDet.size()) - 1) {
				driverDetails = driverDetails + Integer.toString(i + 1);
			} else {
				driverDetails = driverDetails + Integer.toString(i + 1) + ", ";
			}
			// This calls all the data in the list so it can be displayed as a
			// whole
			System.out.println("Driver " + (i + 1) + " is : " + driverDet.get(i).display() + "[" + (i + 1) + "]\n");

		}
		return driverDetails;// returns the String
	}

	public int shelveselection(List<Shelf> numberOfShelves) {
		String ShelfIndexes = "";

		ShelfIndexes = ShelfIndexes + (numberOfShelves);
		int selection = 0;
		do {
			System.out.print("\nPlease select the Shelves required [" + ShelfIndexes + "]: ");
			selection = Validate.validateInteger();
			// if the wrong index is selected print an error mesage
			if (selection < 1 || selection > (numberOfShelves.size())) {
				System.out.print("\nWhoops****\nThis is not a valid choice, please try again\n\n");
			}
		} while (selection < 1 || selection > (numberOfShelves.size()));

		return selection;
	}

	private String shelfNumber(List<Shelf> numberOfShelves) {
		// TODO Auto-generated method stub
		String ShelfIndexes = "";
		for (int i = 0; i < numberOfShelves.size(); i++) {
			if (i == (numberOfShelves.size()) - 1) {
				ShelfIndexes = ShelfIndexes + Integer.toString(i + 1);
			} else {
				ShelfIndexes = ShelfIndexes + Integer.toString(i + 1) + ", ";
			}

			System.out.println("Cage " + (i + 1) + " is : " + numberOfShelves.get(i).getshelfNumber()
					+ numberOfShelves.get(i).getCatag() + "[" + (i + 1) + "]\n");
			
		}
		return ShelfIndexes;// returns the String
	}
	// ======================================================================

	private Shelf populateShelfDetail(String line) {
		// TODO Auto-generated method stub
		String[] data;
		if (line == null) {
			return null;
		} else {
			// the content, line.split(",") returns a list[] of strings
			// separated by a tab
			data = line.split(",");
			return new Shelf(data[0].toUpperCase(), data[1].toUpperCase());
		}
	}

	private String shelfDetails(List<Shelf> numberOfShelves) {
		String shelfDetails = "";
		for (int i = 0; i < numberOfShelves.size(); i++) {
			if (i == (numberOfShelves.size()) - 1) {
				shelfDetails = shelfDetails(null) + Integer.toString(i + 1);
			} else {
				shelfDetails = shelfDetails + Integer.toString(i + 1) + ", ";
			}
			// This calls all the data in the list so it can be displayed as a
			// whole
			System.out.println("Cage " + (i + 1) + " is : " + numberOfShelves.get(i).display() + "[" + (i + 1) + "]\n");

		}
		return shelfDetails;// returns the String
	}

	private int indexProcessing(List<Driver> driverDet, String nameToBeRemoved) {
		// TODO Auto-generated method stub
		int index = 0;
		int counter = 0;
		// System.out.println("Available names are:\n");
		for (int i = 0; i < driverDet.size(); i++) {

			if (driverDet.get(i).getDriverName().toLowerCase().equals(nameToBeRemoved.toLowerCase())) {
				index = i;
				break;
			}
			counter = i + 1;
		}
		if (counter == driverDet.size()) {
			// No matching name is found, return index=-1
			index = -1;
		}
		return index;
	}

	private int indexprocessing(List<Picker> pickerDet, String PickerToBeRemoved) {
		// TODO Auto-generated method stub
		int index = 0;
		int counter = 0;
		// System.out.println("Available names are:\n");
		for (int i = 0; i < pickerDet.size(); i++) {

			if (pickerDet.get(i).getpickerName().toLowerCase().equals(PickerToBeRemoved.toLowerCase())) {
				index = i;
				break;
			}
			counter = i + 1;
		}
		if (counter == pickerDet.size()) {
			// No matching name is found, return index=-1
			index = -1;
		}
		return index;
	}
}
