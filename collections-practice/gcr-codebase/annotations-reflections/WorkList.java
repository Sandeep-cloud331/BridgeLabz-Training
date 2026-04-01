import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project{

    @Todo(task = "Implement feature 1", assignedTo = "Alice")
    void task1(){
        System.out.println("DO TASK 1");
    }

    @Todo(task = "Implement feature 2", assignedTo = "Bob", priority = "HIGH")
    void task2(){
        System.out.println("DO TASK 2");
    }

    @Todo(task = "Implement feature 3", assignedTo = "Claudia", priority = "LOW")
    void task3(){
        System.out.println("DO TASK 3");
    }
}


public class WorkList {
    public static void main(String[] args) throws Exception{
        Method m1 = Project.class.getDeclaredMethod("task1");
        Method m2 = Project.class.getDeclaredMethod("task2");
        Method m3 = Project.class.getDeclaredMethod("task3");

        Todo n1 = m1.getAnnotation(Todo.class);
        Todo n2 = m2.getAnnotation(Todo.class);
        Todo n3 = m3.getAnnotation(Todo.class);

        System.out.println(n1.task() + " -> " + n1.assignedTo() + " - " + n1.priority());
        System.out.println(n2.task() + " -> " + n2.assignedTo() + " - " + n2.priority());
        System.out.println(n3.task() + " -> " + n3.assignedTo() + " - " + n3.priority());
    }
}
