import java.util.Arrays;
import java.util.Scanner;

public class SplitTheText {
    static String[] splittingTheText(String s){
        String[] wordArray=new String[s.length()];
        String w="";
        int count=0;
        for(char c:s.toCharArray()){
            if(c==' '){
                if (!w.isEmpty()) {  // Skip empty words
                    wordArray[count++] = w;
                    w="";
                }

            }else{
                w+=c;
            }
        }
        if(!w.isEmpty()){
            wordArray[count++]=w;
        }
        return Arrays.copyOf(wordArray,count);
    }
    static boolean compareStringArray(String[] s1, String[] s2){
        if(s1.length!=s2.length) return false;
        for(int i=0;i<s1.length;i++){
            if(!s1[i].equals(s2[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] words=str.split(" ");
        String[] wordsUsingMethod=splittingTheText(str);
        if(compareStringArray(words,wordsUsingMethod)){
            System.out.println("both are equal");
            System.out.println(Arrays.toString(words));
        }else{
            System.out.println("both are not equal");
        }
    }
}
