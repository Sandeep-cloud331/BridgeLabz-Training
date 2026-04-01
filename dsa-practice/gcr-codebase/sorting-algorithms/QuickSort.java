import java.util.*;

public class QuickSort{
    public static void quickSort(int[] productPrice, int low, int high){
        if(low < high){
            int p = partition(productPrice, low, high);

            quickSort(productPrice, low, p-1);
            quickSort(productPrice, p+1, high);
        }
    }

    public static int partition(int[] productPrice, int low, int high){
        int pivot = productPrice[high];
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(productPrice[j] < pivot){
                i++;
                int temp = productPrice[i];
                productPrice[i] = productPrice[j];
                productPrice[j] = temp;
            }
        }

        int temp = productPrice[i+1];
        productPrice[i+1] = productPrice[high];
        productPrice[high] = temp;

        return i+1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] productPrice = new int[n];

        for(int i = 0; i < n; i++){
            productPrice[i] = sc.nextInt();
        }

        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(productPrice));
        System.out.println("After Sorting: ");
        quickSort(productPrice);
        System.out.println(Arrays.toString(productPrice));
    }
}