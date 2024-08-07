package com.library;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;
import com.library.service.BookService;


public class LibraryManagementApp {
    @SuppressWarnings("resource")
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Adding n number of books
        System.out.print("Enter the number of books to add: ");

        int numOfBooks = scanner.nextInt();
        scanner.nextLine();

        for (int run = 0; run < numOfBooks; run++){
            System.out.print("Enter book " + (run + 1) + ": ");
            bookService.addBook(scanner.nextLine());
        }

        // Retrieving all the books
        bookService.getAllBooks();

    }
}