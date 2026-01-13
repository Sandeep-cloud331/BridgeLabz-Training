import java.util.*;
import java.util.regex.*;

public class ValidUsername {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username (must be 5-15 long, (a-z),(A-Z),(0,9)) : ");
        String userName = sc.next();
        Pattern pattern = Pattern.compile("^\\D[(a-z)(A-Z)(0-9)_]{5,15}");
        Matcher matcher = pattern.matcher(userName);

        if(matcher.matches()) System.out.println("Username is valid");
        else System.out.println("Username is not valid");

    }
}
