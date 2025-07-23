package reports;

import auth.User;
import inventory.Book;
import java.util.*;

public class ReportServices {
    public static void adminReports(Map<String, User> users, Map<String, Book> books) {
        System.out.println("Books with low quantity:");
        for (Book b : books.values()) if (b.quantity <= 2) System.out.println(b.name);
        System.out.println("Unborrowed Books:");
        for (Book b : books.values()) {
            boolean borrowed = false;
            for (User u : users.values()) if (u.borrowedBooks.contains(b.isbn)) borrowed = true;
            if (!borrowed) System.out.println(b.name);
        }
    }
}
