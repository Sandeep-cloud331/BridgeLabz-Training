import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SmartCityManagement {
    private static List<TransportService> services = Arrays.asList(
        new BusService(),
        new MetroService(),
        new TaxiService(),
        new EVService(),
        new AmbulanceService(),
        new FireService(),
        new PoliceService()
    );

    private static List<Passenger> passengers = Arrays.asList(
        new Passenger("Alice", 700.0, "Agra-Jaipur", new BusService()),
        new Passenger("Bob", 650.0, "Delhi-Gurgaon", new TaxiService()),
        new Passenger("Claude", 50.0, "DelhiMetro - DwarkaNoida", new MetroService()),
        new Passenger("Eden", 14, "Agra EV Stand", new EVService()),
        new Passenger("Harper", 0, "Emergency Route", new AmbulanceService()),
        new Passenger("Anna", 0, "Emergency Route", new PoliceService()),
        new Passenger("Olive", 0.0, "Emergency Route", new FireService())
    );

    public static void displayMenu(){
        System.out.println("\n---------- SMART CITY TRANSPORT SYSTEM ---------");
        System.out.println("1. View All Transport Services");
        System.out.println("2. Filter based by low Fare.");
        System.out.println("3. Emergency Service");
        System.out.println("4. View Dashboard");
        System.out.println("5. View Revenue");
        System.out.println("6. Calculate fare by distance");
        System.out.println("7. Exit");
    }

    public static void showRevenue(){
        System.out.println("Revenue Report: ");
        DoubleSummaryStatistics stats = passengers.stream().collect(Collectors.summarizingDouble(p -> p.getFare()));
        System.out.println("Total Revenue: " + stats.getSum());
        System.out.println("Average Fare: " + stats.getAverage());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean b = true;

        while(b){
            displayMenu();
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("All Transport Services: ");
                    services.forEach(TransportService::printServiceDetails);
                    break;

                case 2: 
                    services.stream().sorted(Comparator.comparingDouble(s -> Arrays.stream(s.getFair()).min().orElse(Double.MAX_VALUE)))
                            .forEach(TransportService::printServiceDetails);
                    break;
                
                case 3:
                    System.out.println("Emergency Service: ");
                    services.stream().filter(s -> s instanceof EmergencyService)
                            .forEach(s -> System.out.println(s.getService()));
                    break;
                
                case 4:
                    System.out.println("Dashboard: ");
                    services.forEach(s -> System.out.println(s.getService() + " -> " + Arrays.toString(s.getRoute()) + " -> " + Arrays.toString(s.getDepartureTime())));
                    break;

                case 5: 
                    showRevenue();
                    break;
                
                case 6:
                    System.out.println("Enter distance(Km): ");
                    double distance = sc.nextDouble();

                    FareCalculator c = d -> d * 10;
                    System.out.println("Estimated fare: " + c.calcualteFare(distance));
                    break;
                
                case 7: 
                    System.out.println("Exiting Smart city app ....");
                    b = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        sc.close();
    }

}
