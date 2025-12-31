import java.util.*;

public class FirstNegativeNumber{
    public static int linearSearch(int[] arr, int target){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(arr[i] == target){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(linearSearch(arr, target));
    }
}