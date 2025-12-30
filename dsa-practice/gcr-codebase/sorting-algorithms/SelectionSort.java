import java.util.*;

public class SelectionSort{
    public static void selectionSort(int[] scores){
        int n = scores.length;

        for(int i = 0; i < n-1; i++){
            int idx = i;

            for(int j = i+1; j < n; j++){
                if(scores[j] < scores[idx]){
                    idx = j;
                }
            }

            int temp = scores[idx];
            scores[idx] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores  = new int[n];

        for(int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
        }

        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(scores));
        System.out.println("After Sorting: ");
        selectionSort(scores);
        System.out.println(Arrays.toString(scores));
    }
}