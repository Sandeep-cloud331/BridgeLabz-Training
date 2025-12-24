public class Employee {
    public int employeeID;        // public
    protected String department;  // protected
    private double salary;         // private

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // public method to modify salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    // main method for testing
    public static void main(String[] args) {
        Manager manager = new Manager(101, "IT", 50000);

        manager.showDetails();
        manager.setSalary(60000);

        System.out.println("Updated Salary: " + manager.getSalary());
    }
}

class Manager extends Employee {

    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void showDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}
