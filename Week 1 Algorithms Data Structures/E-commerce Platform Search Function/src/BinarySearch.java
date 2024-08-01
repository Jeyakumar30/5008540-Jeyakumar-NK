import java.util.Arrays;

public class BinarySearch {
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid]; // Product found
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Apple iPhone 14", "Electronics"),
            new Product("P002", "Nike Air Max 270", "Footwear"),
            new Product("P003", "Samsung Galaxy S23", "Electronics"),
            new Product("P004", "Sony WH-1000XM4", "Audio")            
        };

        // Sorting the array using binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

        // Linear search
        Product foundProduct1 = LinearSearch.linearSearch(products, "P003");
        System.out.println("Linear Search Result: " + (foundProduct1 != null ? foundProduct1 : "Product not found"));

        // Binary search
        Product foundProduct2 = binarySearch(products, "P003");
        System.out.println("Binary Search Result: " + (foundProduct2 != null ? foundProduct2 : "Product not found"));
    }
}