import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {

        // HashMap: store product prices
        Map<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Laptop", 60000);
        priceMap.put("Mouse", 800);
        priceMap.put("Keyboard", 1500);
        priceMap.put("Monitor", 12000);

        // LinkedHashMap: maintain order of items added
        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Mouse", priceMap.get("Mouse"));
        cart.put("Laptop", priceMap.get("Laptop"));
        cart.put("Keyboard", priceMap.get("Keyboard"));

        System.out.println("Cart (Order Added):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 3️⃣ TreeMap: sort items by price
        Map<Integer, List<String>> sortedByPrice = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            int price = entry.getValue();
            String product = entry.getKey();

            sortedByPrice
                .computeIfAbsent(price, k -> new ArrayList<>())
                .add(product);
        }

        System.out.println("\nCart (Sorted by Price):");
        for (Map.Entry<Integer, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " → ₹" + entry.getKey());
            }
        }
    }
}
