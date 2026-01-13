import java.util.*;
import java.util.regex.*;

public class ExtractEmail {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence : ");
        String sentence = sc.nextLine();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(sentence);

        while(matcher.find()){
            System.out.println("Mail Founded : " +matcher.group());
        }

    }
}
