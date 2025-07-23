package inventory;

import java.util.*;

public class InventoryService {
    public static void addBook(Map<String, Book> books, Scanner sc) {
        System.out.println("Book Name:");
        String name = sc.nextLine();
        System.out.println("ISBN:");
        String isbn = sc.nextLine();
        System.out.println("Quantity:");
        int qty = sc.nextInt();
        System.out.println("Cost:");
        double cost = sc.nextDouble(); sc.nextLine();
        books.put(isbn, new Book(name, isbn, qty, cost));
        System.out.println("Book added!");
    }

    public static void modifyBook(Map<String, Book> books, Scanner sc) {
        System.out.println("Enter ISBN to modify:");
        String isbn = sc.nextLine();
        if (books.containsKey(isbn)) {
            System.out.println("New Quantity:");
            books.get(isbn).quantity = sc.nextInt(); sc.nextLine();
        }
    }

    public static void deleteBook(Map<String, Book> books, Scanner sc) {
        System.out.println("Enter ISBN to delete:");
        String isbn = sc.nextLine();
        books.remove(isbn);
        System.out.println("Book Deleted");
    }

    public static void viewBooks(Map<String, Book> books) {
        for (Book b : books.values()) {
            System.out.println(b.name + " | ISBN: " + b.isbn + " | Qty: " + b.quantity + " | Cost: " + b.cost);
        }
    }

    public static void searchBook(Map<String, Book> books, Scanner sc) {
        System.out.println("Enter Name or ISBN:");
        String search = sc.nextLine();
        for (Book b : books.values()) {
            if (b.name.contains(search) || b.isbn.equals(search))
                System.out.println(b.name + " | ISBN: " + b.isbn);
        }
    }
}