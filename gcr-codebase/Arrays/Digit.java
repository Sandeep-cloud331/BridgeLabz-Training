import java.util.*;
public class Digit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input of any number
        System.out.println("Enter any number : ");
        int n = sc.nextInt();

        int size = 10;
        int[] d = new int[size];
        int idx = 0;

        while (n != 0 && idx < size) {
            d[idx++] = n % 10;
            n /= 10;
        }

        // Finding the largest and second largest
        int largest = -1, second = -1;
        for (int i = 0; i < idx; i++) {
            if (d[i] > largest) {
                second = largest;
                largest = d[i];
            } else if (d[i] > second && d[i] != largest) {
                second = d[i];
            }
        }

        // Printing the results
        System.out.println("Largest number : "+largest);
        System.out.println("Second largest number : "+second);
    }
}