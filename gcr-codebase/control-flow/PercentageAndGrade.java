import java.util.Scanner;

public class PercentageAndGrade {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int physics=sc.nextInt();
        int chemistry=sc.nextInt();
        int maths=sc.nextInt();
        int percentage= (((physics+chemistry+maths)*100)/300);
        if(percentage>=80){
            System.out.println("Grade: A, Remark: Level 4, above agency-normalized standards, Marks: "+percentage);
        }else if(percentage>=70 && percentage<80){
            System.out.println("Grade: B, Remark: Level 3, at agency-normalized standards, Marks: "+percentage);
        }else if(percentage>=60 && percentage<70){
            System.out.println("Grade: C, Remark: Level 2, below, but approaching agency-normalized standards, Marks: "+percentage);
        }else if(percentage>=50 && percentage<60){
            System.out.println("Grade: D, Remark: Level 1, well below agency-normalized standards, Marks: "+percentage);
        }else if(percentage>=40 && percentage<50){
            System.out.println("Grade: E, Remark: Level 1, too below agency-normalized standards, Marks: "+percentage);
        }else{
            System.out.println("Grade: R, Remark: Remedial standards");
        }
    }
}
