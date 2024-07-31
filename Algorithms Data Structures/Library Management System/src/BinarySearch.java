import java.util.Arrays;

public class BinarySearch {
    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid]; // Book found
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "Effective Java", "Joshua Bloch"),
            new Book("B002", "Java: The Complete Reference", "Herbert Schildt"),
            new Book("B003", "Head First Java", "Kathy Sierra and Bert Bates"),
            new Book("B004", "Java Concurrency in Practice", "Brian Goetz")            
        };

        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        Book foundBook1 = LinearSearch.linearSearch(books, "Java: The Complete Reference");
        System.out.println("Linear Search Result: " + (foundBook1 != null ? foundBook1 : "Book not found"));

        Book foundBook2 = binarySearch(books, "Java Concurrency in Practice");
        System.out.println("Binary Search Result: " + (foundBook2 != null ? foundBook2 : "Book not found"));
    }
}