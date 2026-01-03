interface Category {}
class BookCategory implements Category{}
class ClothingCategory implements Category{}
class GadgetCategory implements Category{}

class ProductType<T extends Category>{
    String name;
    double price;
    T category;

    ProductType(String name, double price, T category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString(){
        return name + " - $" + price;
    }
}

class Product{
    static <T extends ProductType<?>> void applyDiscount(T product, double percent){
        product.price -= product.price * percent / 100;
    }
}