import java.util.Scanner;

public class LengthOfStringWithoutUsingLengthMethod {
    static int findingLength(String s){
        int count=0;
        try{
            while(true){
                char c=s.charAt(count);
                count++;
            }
        }catch (StringIndexOutOfBoundsException e){
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int lenManually=findingLength(str);
        int len=str.length();
        System.out.println("Length using user defined method: "+lenManually);
        System.out.println("Length using builtin length method: "+len);
    }
}
