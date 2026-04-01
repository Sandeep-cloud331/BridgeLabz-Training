import java.util.Scanner;

public class CompareUpperCaseString {
    static String generateUpperCase(String str){
        String upperCase="";
        for(char c:str.toCharArray()){
            if (c == ' ') {
                upperCase += " ";  // Preserve spaces
            } else if (c >= 'A' && c <= 'Z') {
                upperCase += c;  // Already uppercase
            } else if (c >= 'a' && c <= 'z') {
                upperCase += (char)(c - 32);  // a→A: subtract 32
            } else {
                upperCase += c;  // Non-letter characters
            }
        }
        return upperCase;
    }
    static boolean compareString(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String strInUpperCaseBuiltIn=str.toUpperCase();
        String strInUpperCaseManual=generateUpperCase(str);
        if(compareString(strInUpperCaseBuiltIn,strInUpperCaseManual)){
            System.out.println("Both Strings are equal & in upper case: "+strInUpperCaseManual);
        }else{
            System.out.println("Both Strings are not equal & in upper case");
        }
    }
}
