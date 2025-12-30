import java.util.*;

public class InsertionSort{
    public static void insertionSort(int[] id){
        int n = id.length;

        for(int i = 1; i < n; i++){
            int num = id[i];
            int j = i-1;

            while(j >= 0 && id[j] > num){
                id[j+1] = id[j];
                j--;
            }

            id[j+1] = num;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] id = new int[n];

        for(int i = 0; i < n; i++){
            id[i] = sc.nextInt();
        }

        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(id));
        System.out.println("After Sorting: ");
        insertionSort(id);
        System.out.println(Arrays.toString(id));
    }
}