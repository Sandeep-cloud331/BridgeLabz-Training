import java.util.*;

public class RotationPoint{
    public static int findRotationPoint(int[] arr){
        int n = arr.length;
        int left = 0, right = n-1;
        

        while(left !=  right){
            int mid = (left + right)/2;
            if(arr[mid] > arr[right]){
                left = mid + 1;
            }
            if(arr[mid] < arr[right]){
                right = mid;
            }
        }

        return arr[left];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(findRotationPoint(arr));
    }
}