class Product{
    int id;
    String name;
    int quantity;
    double price;
    Product next;

    public Product(int id, String name, int quantity, double price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class Inventory{
    Product head = null;

    public void addBeginning(int id, String name, int quantity, double price){
        Product item = new Product(id, name, quantity, price);
        item.next = head;
        head = item;
    }

    public void addEnd(int id, String name, int quantity, double price){
        Product item = new Product(id, name, quantity, price);
        Product node = head;

        if(head == null) { head = item; }

        while(node.next != null){
            node = node.next;
        }

        node.next = item;
    }

    public void addPosition(int pos, int id, String name, int quantity, double price){
        if(pos <= 1){
            addBeginning(id, name, quantity, price);
            return;
        }

        Product item = new Product(id, name, quantity, price);
        Product node = head;

        for(int i = 1; node != null && i < (pos-1) ; i++){
            node = node.next;
        }

        if(node == null) System.out.println("Invalid position!");

        item.next = node.next;
        node.next = item;
    }

    public void removeItem(int id){
        if(head == null) {return;}
        if(head.id == id){
            head = head.next;
            return;
        }

        while(node.next != null && node.next.id != id){
            node = node.next;
            if(node.next == null){
                System.out.println("Product not found!");
            }
        }

        node.next = node.next.next;
    }

    public void updateQuantity(int id, int quan){
        Product node = head;

        while(node != null){
            if(node.id == id){
                node.quantity = quan;
                System.out.println("quantity updated!");
                return;
            }
            node = node.next;
        }

        System.out.println("Product not found!");
    }

    public void searchProductId(int id){
        Product node = head;

        while(node != null){
            if(node.id == id){
                System.out.println("Found! " + node.name + " price: " + node.price);
                return;
            }
            node = node.next;
        }

        System.out.println("Product not found!");
    }

    public void searchProductName(String name){
        Product node = head;

        while(node != null){
            if(node.name == name){
                System.out.println("Found! " + node.name + " price: " + node.price);
                return;
            }
            node = node.next;
        }

        System.out.println("Product not found!");
    }

    public void totalValue(){
        Product node = head;

        while(node != null){
            System.out.println("Product: " + node.name + "Total: " + (node.quantity * node.price));
            node = node.next;
        }
    }

    public void displayAll(){
        if(head == null){
            System.out.println("No records!");
            return;
        }

        StudentInfo node = head;
        while(node != null){
            System.out.println("Product ID: " + node.id + "\nName: " + node.name + "\nQuantity: " + node.quantity + "\nPrice: " + node.price);
            node = node.next;
        }
    }
    
    public static void main(String[] args) {
        Inventory im = new Inventory();
        im.addBeginning(101, "Pen", 50, 10.0);
        im.addBeginning(102, "Notebook", 30, 25.0);
        im.displayAll();
        im.updateQuantity(101, 60);
        im.removeItem(102);
        im.displayAll();
    }

}