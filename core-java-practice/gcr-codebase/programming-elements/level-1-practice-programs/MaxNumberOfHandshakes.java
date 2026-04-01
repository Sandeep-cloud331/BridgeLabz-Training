import java.util.Scanner;

public class MaxNumberOfHandshakes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Students");
        int numberOfStudents=sc.nextInt();
        //formula (n*(n-1))/2 where n=number of students
        int handshakes=(numberOfStudents*(numberOfStudents-1))/2;
        System.out.println("Total number of possible handshakes: "+handshakes);
    }
}
