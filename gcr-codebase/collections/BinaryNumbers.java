import java.util.*;

public class BinaryNumbers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Queue size: ");
        int n = sc.nextInt();

        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String curr = queue.remove();
            System.out.print(curr + " ");

            queue.add(curr + "0");
            queue.add(curr + "1");
        
        }

        //System.out.println(queue);        
    }
} 