import java.util.Scanner;
public class FindHandshakes {

    // method to find handshakes
    public static int handshakes(int n){
        return (n*(n-1))/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input
        int n = sc.nextInt();

        // method calling 
        int ans  = handshakes(n);

        // output 
        System.out.println(ans);
    }
}
