import java.util.*;
import java.util.regex.*;

public class LicensePlateNumber {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the License Plate number : ");
        String plateNumber = sc.next();
        Pattern pattern = Pattern.compile("^[A-Z]{2}[0-9]{4}");
        Matcher matcher = pattern.matcher(plateNumber);

        if(matcher.matches()) System.out.println("Plate Number is valid");
        else System.out.println("Plate Number is not valid");

    }
}
