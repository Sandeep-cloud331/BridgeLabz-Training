import java.util.*;

public class MultipleCatch{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        System.out.println("Enter array elements: ");
        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter index: ");
        int idx = sc.nextInt();

        try{
            System.out.println(arr[idx]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index!");
        }
        catch(NullPointerException e){
            System.out.println("Array is not initalized");
        }
    }
}