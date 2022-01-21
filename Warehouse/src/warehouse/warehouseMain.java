package warehouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class warehouseMain {
	public static void main(String[] args) throws IOException {
		List<Route> routeNo = new ArrayList<Route>();

		Menu myMenu = new Menu();

		
		String path = "Data Files\\";
		String nameOfFile = "RouteAvailability.txt";

		BufferedReader in = Validate.checkFile(path + nameOfFile); 
		String str;
		int count = 0; 

		
		while ((str = in.readLine()) != null)// exit the loop only when there
												// are no more lines
		{

			routeNo.add(populateRouteDetails(str));
			routeNo.get(count).setareaID("Route " + (count + 1));
			count++;
		}
		in.close(); // close the file
		
		// Display the menu
		myMenu.display(routeNo);
	}


	
	private static Route populateRouteDetails(String line) {
		String[] data;
		if (line == null) {
			return null;
		} else {
			
			data = line.split(",");
			return new Route(data[0].toUpperCase());
		}

	}

}
