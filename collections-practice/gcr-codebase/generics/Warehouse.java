import java.util.*;

abstract class WarehouseItems{
    String name;

    WarehouseItems(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}

class Electronics extends WarehouseItems{
    Electronics(String name){
        super(name);
    }
}

class Groceries extends WarehouseItems{
    Groceries(String name){
        super(name);
    }
}

class Furniture extends WarehouseItems{
    Furniture(String name){
        super(name);
    }
}

class Warehouse<T extends WarehouseItems> {
    private List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    List<T> getItems() {
        return items;
    }

    static void displayItems(List<? extends WarehouseItems> items){
        for(WarehouseItems item : items){
            System.out.println(item);
        }
    }
}