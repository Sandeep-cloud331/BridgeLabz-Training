import java.util.*;

public class FindWordInSentences{
    public static String findSentenceWithWord(String[] sentence, String word){
        int n = sentence.length;

        for(String s : sentence){
            String[] words = s.split(" ");
            for(String w : words){
                if(w.equals(word)){
                    return s;
                }
            }
        }

        return  "Not Found!";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] sentence = new String[n];

        for(int i = 0; i < n; i++){
            sentence[i] = sc.nextLine();
        }

        String word = sc.nextLine();

        System.out.println(findSentenceWithWord(sentence, word));
    }
}