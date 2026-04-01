import java.util.Scanner;
public class WindChill {

    // method to calculate wind chill
    public static double calculateWindChill(double temp, double windSpeed){
        double ans = 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
        return ans; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input for temperature and windSpeed
        double temperature = sc.nextDouble();
        double windSpeed = sc.nextDouble();

        // method calling
        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.println(windChill);

        sc.close();
    }
}
