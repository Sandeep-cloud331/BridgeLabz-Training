interface Worker {
    void performDuties();
}

// Super class
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Sub class
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Chef) is preparing delicious food.");
    }
}

// Sub class
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Waiter) is serving customers.");
    }
}


public class RestaurantSystem {
    public static void main(String[] args) {

        // Objects created
        Worker chef = new Chef("Gordon", 101);
        Worker waiter = new Waiter("Tom", 202);

        chef.performDuties();
        waiter.performDuties();
    }
}