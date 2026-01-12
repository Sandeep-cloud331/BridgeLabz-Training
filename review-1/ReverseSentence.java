import java.util.*;

public class ReverseSentence{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your sentence: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i = (words.length-1); i >= 0; i--){
            sb.append(words[i]);
            sb.append(" ");
        }

        System.out.println("\nReversed sentence: ");
        System.out.println(sb.toString());
    }
}