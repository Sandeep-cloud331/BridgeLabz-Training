import java.util.*;

class StudentInfo{
    String name;
    int age;
    int rollNo;
    char grade;
    Student next;

    public StudentInfo(int rollNo, String name, int age, char grade){
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class Student{
    Student head = null;


    public void addBeginning(int rollNo, String name, int age, char grade){
        StudentInfo student1 = new StudentInfo(rollNo, name, age, grade);
        student1.next = head;
        head = student1;
    }

    public void addEnd(int rollNo, String name, int age, char grade){
        StudentInfo student1 = new StudentInfo(rollNo, name, age grade);

        if(head == null) {
            head = student1;
            return;
        }

        StudentInfo node = head;

        while(node.next != null){
            node = node.next;
        }

        node.next = student1;
    }

    public void addPosition(int pos, int rollNo, String name, int age, char grade){
        if(pos <= 1){
            addBeginning(rollNo, name, age , grade);
            return;
        }

        StudentInfo student1 = new StudentInfo(rollNo, name, age, grade);
        StudentInfo node = head;

        for(int i = 1; node != null && i < (pos - 1) ; i++){
            node = node.next;
        }

        if(node == null) System.out.println("Invalid position!");

        student1.next = node.next;
        node.next = student1;
    }

    public void deleteStudent(int rollNo){
        if(head == null) return;
        if(head.rollNo == rollNo){
            head = head.next;
            return;
        }

        StudentInfo node = head;
        while(node.next != null && node.next.rollNo != rollNo){
            node = node.next;
            if(node.next == null){
                System.out.println("Student not found!");
            }
        }

        node.next = node.next.next;
    }

    public void searchStudent(int rollNo){
        StudentInfo node = head;

        while(node != null){
            if(node.rollNo == rollNo){
                System.out.println("Found! " + node.name + " grade: " + node.grade);
                return;
            }
            node = node.next;
        }

        System.out.println("Student not found!");
    }

    public void updateGrade(int rollNo, char newGrade){
        StudentInfo node = head;

        while(node != null){
            if(node.rollNo == rollNo){
                node.grade = newGrade;
                System.out.println("Grade updated!");
                return;
            }
            node = node.next;
        }

        System.out.println("Student not found!");
    }

    public void displayAll(){
        if(head == null){
            System.out.println("No records!");
            return;
        }

        StudentInfo node = head;
        while(node != null){
            System.out.println("Roll Number: " + node.rollNo + "\nName: " + node.name + "\nAge: " + node.age + "\nGrade: " + node.grade);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Student record = new Student();
        record.addEnd(1, "Alankrati", 20, 'A');
        record.addBeginning(2, "Shivang", 21, 'B');
        record.addPosition(2, 3, "Muskaan", 20, 'A');
        record.displayAll();
        record.updateGrade(3, 'S');
        record.searchStudent(3);
        record.deleteStudent(2);
        record.displayAll();
    }
}
