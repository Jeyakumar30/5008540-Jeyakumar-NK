import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product not found: " + product.getProductId());
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Product removedProduct = inventory.remove(productId);
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void displayAllProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem system = new InventoryManagementSystem();

        system.addProduct(new Product("P001", "Apple", 100, 10.0));
        system.addProduct(new Product("P002", "Nuts", 150, 20.0));

        system.displayAllProducts();

        system.updateProduct(new Product("P001", "Product 1 Updated", 120, 12.0));

        system.displayAllProducts();

        system.deleteProduct("P002");

        system.displayAllProducts();
    }
}


