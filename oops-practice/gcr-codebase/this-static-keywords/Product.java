class Product {

    // Static variable 
    static double discount = 10.0;   // discount in percentage

    // Instance variables
    String productName;
    double price;
    int quantity;
    final int productID;  

    // Constructor using 'this' keyword
    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update discount
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Updated Discount: " + discount + "%");
    }

    // Method using instanceof
    void processProduct(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            double totalPrice = p.price * p.quantity;
            double discountedPrice = totalPrice - (totalPrice * discount / 100);

            System.out.println("Product ID: " + p.productID);
            System.out.println("Product Name: " + p.productName);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Total Price after Discount: ₹" + discountedPrice);
        } else {
            System.out.println("Not a Product object");
        }
    }

    // Main method
    public static void main(String[] args) {
        Product p1 = new Product(201, "Laptop", 50000, 1);
        Product p2 = new Product(202, "Mouse", 500, 2);

        Product.updateDiscount(15);
        System.out.println();

        p1.processProduct(p1);
        System.out.println();

        p2.processProduct(p2);
    }
}
