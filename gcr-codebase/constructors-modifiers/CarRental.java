class CarRental {

    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1500; // fixed rate
    double totalCost;

    // Default Constructor
    CarRental() {
        customerName = "Customer";
        carModel = "Hatchback";
        rentalDays = 1;
        calculateTotalCost();
    }

    // Parameterized Constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateTotalCost();
    }

    // Method to calculate total cost
    void calculateTotalCost() {
        totalCost = rentalDays * costPerDay;
    }

    // Method to display rental details
    void showRentalDetails() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days   : " + rentalDays);
        System.out.println("Total Cost    : ₹" + totalCost);
        System.out.println("");
    }

    public static void main(String[] args) {

        // Using default constructor
        CarRental r1 = new CarRental();
        r1.showRentalDetails();

        // Using parameterized constructor
        CarRental r2 = new CarRental("Nikhil", "Sedan", 4);
        r2.showRentalDetails();
    }
}
