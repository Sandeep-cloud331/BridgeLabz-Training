public class Product {

    // Instance variables
    String productName;
    double price;

    // Class variable (shared by all objects)
    static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Class method
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    // Main method for testing
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 500);

        p1.displayProductDetails();
        System.out.println();

        p2.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts();
    }
}
