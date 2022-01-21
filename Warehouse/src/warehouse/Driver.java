package warehouse;

public class Driver {
	
	
	private String driverName;
	private String deliverType;
	private String vehicleID;

	public Driver(String driverName, String vehicleID, String deliverType) {
		// TODO Auto-generated constructor stub
		this.driverName = driverName;
		this.deliverType = deliverType;
		this.vehicleID = vehicleID;
	}

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public void details() {
		System.out.print("Please Enter the Driver Details" + "\nPlease enter the name of the Driver: ");
		setDriverName(Validate.validateString());
		System.out.print("Please enter the type of Delivery: ");
		setDeliveryType(Validate.validateString());
		System.out.print("Please enter the Vehicle ID: ");
		setVehicleID(Validate.validateString());
	}


	public String displayDetails(int index) {
		return "\nAnimal " + index + "... \nName of Driver: " + getDriverName() + "\n type of Delivery" + getDeliveryType();
	}


	public static void add(Driver driver) {
		// TODO Auto-generated method stub

	}

	String getDriverName() {
		return driverName;
	}

	private void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	String getDeliveryType() {
		return deliverType;
	}

	void setDeliveryType(String deliverType) {
		this.deliverType = deliverType;
	}

	public void setDriver(String string) {
		// TODO Auto-generated method stub

	}

	public String display() {
		// TODO Auto-generated method stub
		return deliverType + " " + driverName + " " + vehicleID;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	

}
