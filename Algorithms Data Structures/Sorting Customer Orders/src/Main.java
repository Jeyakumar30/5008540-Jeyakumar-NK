import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
                new Order("O001", "Jeyakumar", 1300.25),
                new Order("O002", "Charan Kumar", 1150.75),
                new Order("O003", "Thejesh Babu", 5200.05),
                new Order("O004", "Surya Prakash", 2150.20)
        };

        System.out.println("Original Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        BubbleSort.bubbleSort(bubbleSortedOrders);
        System.out.println("\nBubble Sorted Orders:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        // Quick Sort
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nQuick Sorted Orders:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}