import java.lang.reflect.*;
import java.util.*;

class Employee{
    public static void main(String[] arg) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = sc.nextLine();

        Class<?> cls = Class.forName(className);

        System.out.println("\nMethods:");
        for (Method m : cls.getDeclaredMethods()) {
            System.out.println(m.getName());
        }

        System.out.println("\nFields:");
        for (Field f : cls.getDeclaredFields()) {
            System.out.println(f.getName());
        }

        System.out.println("\nConstructors:");
        for (Constructor<?> c : cls.getDeclaredConstructors()) {
            System.out.println(c);
        }


        Person person = new Person();
        Class<?> cls2 = person.getClass();

        Field field = cls.getDeclaredField("age");
        field.setAccessible(true);

        field.set(person, 25);
        System.out.println("Age: " + field.get(person));

        Calculator calc = new Calculator();
        Class<?> cls3 = calc.getClass();

        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);

        Object result = method.invoke(calc, 4, 5);
        System.out.println("Result: " + result);

    }
}

class Person {
    private int age = 20;
}

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}


