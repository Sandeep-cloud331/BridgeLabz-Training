import java.util.Scanner;

public class VowelsAndConsonants {
    static void countOfVowelsAndConsonants(String s){
        s=s.toLowerCase();
        int vow=0;       //vowel count
        int con=0;      // consonant count
        for(char c:s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                vow++;
            }else if(c>='a'&& c<='z'){
                con++;
            }
        }
        System.out.println("No. of vowels: "+vow);
        System.out.println("No. of consonants: "+con);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        countOfVowelsAndConsonants(str);
    }
}
