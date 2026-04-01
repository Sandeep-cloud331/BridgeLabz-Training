import java.util.Arrays;
import java.util.Scanner;
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input of any number
        int num = sc.nextInt();
        int c = 0;
        int var = num;

        // Puts the values into an array
        while(var>0){
            c++;
            var/=10;
        }
        int[] arr = new int[c];
        int idx=arr.length-1;
        while(num>0){
            int rem = num%10;
            arr[idx--]=rem;
            num/=10;
        }
        idx=0;

        // Prints the reverse number
        int[] reverse_num = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            reverse_num[idx++]=arr[i];
        }
        System.out.println(Arrays.toString(reverse_num));
    }
}
