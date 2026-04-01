import java.util.Scanner;

public class CompareString {
    //method for string comparison
    static boolean stringComparison(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        // built in method
        boolean usingBuiltInMethod=str1.equals(str2);
        boolean usingUserMethod=stringComparison(str1,str2);
        //comparing the result of both
        if (usingBuiltInMethod == usingUserMethod) {
            if (usingBuiltInMethod) {
                System.out.println("Results are same, both strings are equal");
            } else {
                System.out.println("Results are same, both strings are not equal");
            }
        }else{
            System.out.println("Results are not same");
        }
    }
}
