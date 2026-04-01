class Employee {

    // Static variables 
    static String companyName = "Tech Solutions Pvt Ltd";
    static int totalEmployees = 0;

    // Instance variables
    String name;
    final int id;        
    String designation;

    // Constructor using 'this' keyword
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method using instanceof
    void displayDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee Name: " + emp.name);
            System.out.println("Employee ID: " + emp.id);
            System.out.println("Designation: " + emp.designation);
        } else {
            System.out.println("Not an Employee object");
        }
    }

    // Main method
    public static void main(String[] args) {
        Employee e1 = new Employee("Nikhil", 101, "Software Engineer");
        Employee e2 = new Employee("Aman", 102, "Tester");

        e1.displayDetails(e1);
        System.out.println();

        e2.displayDetails(e2);
        System.out.println();

        Employee.displayTotalEmployees();
    }
}
