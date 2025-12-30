import java.util.*;

public class CountSort{
    public static void countSort(int[] ages){
        int n = ages.length;

        int max = ages[0];
        for(int num : ages){
            if(num > max){
                max = num;
            }
        }

        int[] count = new int[max+1];

        for(int num : ages){
            count[num]++;
        }

        int idx = 0;

        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                ages[idx++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ages = new int[n];

        for(int i = 0; i < n; i++){
            ages[i] = sc.nextInt();
        }

        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(ages));
        System.out.println("After Sorting: ");
        countSort(ages);
        System.out.println(Arrays.toString(ages));
    }
}