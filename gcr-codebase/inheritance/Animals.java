// Superclass Animal
abstract class Animal{
    String name;
    int age;

    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    abstract String makeSound();

}

// Subclass dog
class Dog extends Animal{

    Dog(String name, int age){
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Barks..";
    }
}

// Subclass Cat
class Cat extends Animal{

    Cat(String name, int age){
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Meow..";
    }
}

// Sub class Bird
class Bird extends Animal{

    Bird(String name, int age){
        super(name, age);
    }

    @Override
    String makeSound() {
        return "picker picker..";
    }
    
}

public class Animals{
    public static void main(String [] args){
        Animal dog = new Dog("Rocky", 7);
        System.out.println("Dog's name : " +dog.name);
        System.out.println("Dog's age : " +dog.age);
        System.out.println();

        Animal cat = new Cat("Kate", 3);
        System.out.println("Cat's name : " +cat.name);
        System.out.println("Cat's age : " +cat.age);
        System.out.println();

        Animal bird = new Bird("Parry", 1);
        System.out.println("Bird's name : " +bird.name);
        System.out.println("Bird's age :  " +bird.age);
        System.out.println();
    }
}