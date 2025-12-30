import java.util.*;

public class MergeSort{
    public static void parition(int[] prices, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;

            parition(prices, left, mid);
            parition(prices, mid+1, right);
            merge(prices, left, mid, right);
        }
    }

    public static void merge(int[] prices, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftPrice = new int[n1];
        int[] rightPrice = new int[n2];

        System.arraycopy(prices, left, leftPrice, 0, n1);
        System.arraycopy(prices, mid+1, rightPrice, 0, n2);

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2){
            if(leftPrice[i] <= rightPrice[j]){
                prices[k++] = leftPrice[i++];
            }
            else{
                prices[k++] = rightPrice[j++];
            } 
        }

        while(i < n1) prices[k++] = leftPrice[i++];
        while(j < n2) prices[k++] = rightPrice[j++];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];

        for(int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
        }

        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(prices));
        System.out.println("After Sorting: ");
        parition(prices);
        System.out.println(Arrays.toString(prices));
    }
}