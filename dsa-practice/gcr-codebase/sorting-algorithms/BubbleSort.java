import java.util.*;

public class BubbleSort{
    public static void bubblesort(int[] marks){
        int n = marks.length;
        boolean swap;

        for(int i = 0; i < n-1; i++){
            swap = false;
            for(int j = 0; j < (n - i - 1); j++){
                if(marks[j] > marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                    swap = true;
                }
            }

            if(!swap) break;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] marks = new int[n];

        for(int i = 0; i < n; i++){
            marks[i] = sc.nextInt();
        }

        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(marks));
        System.out.println("After Sorting: ");
        bubblesort(marks);
        System.out.println(Arrays.toString(marks));
    }
}