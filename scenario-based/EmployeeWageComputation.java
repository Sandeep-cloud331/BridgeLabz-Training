import java.util.*;

public class EmployeeWageComputation {

    // Displays the program title
    public static void display() {
        System.out.println("\n\nWelcome to Employee Wage Computation Program!");
    }

    // Checks whether an employee is present or absent
    public static void employeeAttendance() {
        Random random = new Random();
        // Randomly generates 0 or 1
        int attendanceStatus = random.nextInt(2);

        // 1 indicates employee is present
        if (attendanceStatus == 1) {
            System.out.println("Present!");
        } else {
            System.out.println("Absent!");
        }
    }

    // Calculates daily wage of an employee
    public static void employeeDailyWage() {
        Random random = new Random();
        int attendance = random.nextInt(2);
        int wagePerHour = 20;
        int workingHours = 0;
        int dailyWage = 0;

        if (attendance == 1) {
            workingHours = 8;
        }

        dailyWage = workingHours * wagePerHour;
        System.out.println("Employee Today's Wage: " + dailyWage);
    }

    // Calculates wage based on part-time or full-time employee
    public static void employeePartWage() {
        Random random = new Random();
        // Generates 0 (absent), 1 (full-time), or 2 (part-time)
        int empType = random.nextInt(3);
        int workHours = 0;
        int totalWage = 0;
        int ratePerHour = 20;

        // Full-time employee
        if (empType == 1) {
            workHours = 8;
        }
        // Part-time employee
        else if (empType == 2) {
            workHours = 4;
        } 
        // Absent employee
        else {
            workHours = 0;
        }

        totalWage = workHours * ratePerHour;
        System.out.println("Employee Wage: " + totalWage);
    }

    // Calculates wage using switch-case
    public static void employeeWageSwitch() {
        Random random = new Random();
        int empStatus = random.nextInt(3);
        int hoursWorked = 0;
        int wage = 0;
        int hourlyRate = 20;

        switch (empStatus) {
            case 1:
                hoursWorked = 8;
                break;
            case 2:
                hoursWorked = 4;
                break;
            default:
                hoursWorked = 0;
                break;
        }

        wage = hoursWorked * hourlyRate;
        System.out.println("Employee Wage through switch case: " + wage);
    }

    // Calculates monthly wage for 20 working days
    public static void employeeWageMonthly() {
        Random random = new Random();
        int hours;
        int ratePerHour = 20;
        int dailyWage = 0;
        int monthlyWage = 0;

        for (int day = 0; day < 20; day++) {
            int empStatus = random.nextInt(3);

            switch (empStatus) {
                case 1:
                    hours = 8;
                    break;
                case 2:
                    hours = 4;
                    break;
                default:
                    hours = 0;
                    break;
            }

            dailyWage = ratePerHour * hours;
            monthlyWage += dailyWage;
        }

        System.out.println("Employee's Month Wage: " + monthlyWage);
    }

    // Calculates wage until 100 working hours or 20 working days are reached
    public static void employeeWageCondition() {
        Random random = new Random();
        int hoursWorked = 0;
        int ratePerHour = 20;
        int wage = 0;
        int totalSalary = 0;
        int totalDays = 0;
        int totalHours = 0;

        while (totalDays != 20 && totalHours != 100) {
            int empStatus = random.nextInt(3);

            switch (empStatus) {
                case 1:
                    hoursWorked = 8;
                    totalDays++;
                    break;
                case 2:
                    hoursWorked = 4;
                    totalDays++;
                    break;
                default:
                    hoursWorked = 0;
                    break;
            }

            totalHours += hoursWorked;
            wage = ratePerHour * hoursWorked;

            if (wage != 0) {
                System.out.println("Employee Wage on day " + totalDays + " is " + wage);
            }

            totalSalary += wage;
        }

        System.out.println("Employee's Wage till 100 hrs or 20 days are reached: " + totalSalary);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            display();

            // Menu options
            System.out.println("\n---------- Your Options ----------");
            System.out.println("1. Check Employee's Attendance.");
            System.out.println("2. Check Employee's Daily Wage.");
            System.out.println("3. Check Employee's Part-Time Wage.");
            System.out.println("4. Check Employee Wage using Switch Case.");
            System.out.println("5. Check Employee's Monthly Wage.");
            System.out.println("6. Check Employee Wage with Condition.");
            System.out.println("7. Exit.");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    employeeAttendance();
                    break;
                case 2:
                    employeeDailyWage();
                    break;
                case 3:
                    employeePartWage();
                    break;
                case 4:
                    employeeWageSwitch();
                    break;
                case 5:
                    employeeWageMonthly();
                    break;
                case 6:
                    employeeWageCondition();
                    break;
                default:
                    System.out.println("Exiting...");
                    exitProgram = true;
            }
        }
    }
}

