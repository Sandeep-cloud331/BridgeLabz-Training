import java.util.*;

public class HeapSort{
    public static void heapSort(int[] salary){
        int n = salary.length;

        for(int i = n/2-1; i >= 0; i--){
            heapify(salary, n, i);
        }

        for(int i = n-1; i > 0; i--){
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            heapify(salary, i, 0);
        }
    }

    public static void heapify(int[] salary, int n, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < n && salary[left] > salary[largest]){
            largest = left;
        }

        if(right < n && salary[right] > salary[largest]){
            largest = right;
        }

        if(largest != i){
            int temp = salary[i];
            salary[i] = salary[largest];
            salary[largest] = temp;

            heapify(salary, n, largest);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] salary = new int[n];

        for(int i = 0; i < n; i++){
            salary[i] = sc.nextInt();
        }

        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(salary));
        System.out.println("After Sorting: ");
        heapSort(salary);
        System.out.println(Arrays.toString(salary));
    }
}