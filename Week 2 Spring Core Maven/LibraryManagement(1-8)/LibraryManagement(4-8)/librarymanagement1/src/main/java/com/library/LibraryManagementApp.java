package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementApp {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // Spring context from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = context.getBean(BookService.class);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("-------------------------");
            System.out.println("Library Management System");
            System.out.println("-------------------------");
            System.out.println("1. Add Book");
            System.out.println("2. List All Books");
            System.out.println("3. Get Book by ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        bookService.addBook(title);
                        System.out.println("Book added successfully.");
                        break;
                    case 2:
                        System.out.println("Fetching all the books....");
                        bookService.getAllBooks().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Enter book ID: ");
                        int id = scanner.nextInt();
                        String book = bookService.getBookById(id);
                        if (book != null) {
                            System.out.println(book);
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter book ID: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new book title: ");
                        String newTitle = scanner.nextLine();
                        bookService.updateBook(updateId, newTitle);
                        System.out.println("Book updated successfully.");
                        break;
                    case 5:
                        System.out.print("Enter book ID: ");
                        int deleteId = scanner.nextInt();
                        bookService.deleteBook(deleteId);
                        System.out.println("Book deleted successfully.");
                        break;
                    case 6:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }

            System.out.println();
        }

        scanner.close();
    }
}