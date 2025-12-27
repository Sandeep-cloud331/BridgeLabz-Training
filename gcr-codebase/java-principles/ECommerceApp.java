import java.util.ArrayList;

// Product class
class Product {
    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    void displayProduct() {
        System.out.println(productName + " - ₹" + price);
    }
}

// Order class 
class Order {
    int orderId;
    ArrayList<Product> products = new ArrayList<>();

    Order(int orderId) {
        this.orderId = orderId;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        double total = 0;

        for (Product p : products) {
            p.displayProduct();
            total += p.price;
        }

        System.out.println("Total Amount: ₹" + total);
    }
}

// Customer class (places orders)
class Customer {
    int customerId;
    String customerName;

    Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    void placeOrder(Order order) {
        System.out.println("Customer: " + customerName + " placed an order");
        order.displayOrderDetails();
    }
}

// Main class
public class ECommerceApp {
    public static void main(String[] args) {

        Product p1 = new Product(101, "Laptop", 55000);
        Product p2 = new Product(102, "Headphones", 2000);
        Product p3 = new Product(103, "Mouse", 500);

        Order order1 = new Order(1);
        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.addProduct(p3);

        Customer customer1 = new Customer(1, "Nikhil");
        customer1.placeOrder(order1);
    }
}
