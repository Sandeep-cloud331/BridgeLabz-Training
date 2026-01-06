import java.util.*;

public class ReverseQueue{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Queue size: ");
        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            queue.add(sc.nextInt());
        }
        
        System.out.println(queue);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            stack.push(queue.remove());
        }

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty()){
                queue.add(stack.pop());
            }
        }

        System.out.println(queue);
    }
} 