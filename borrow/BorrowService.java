package borrow;

import auth.User;
import inventory.Book;
import java.text.SimpleDateFormat;
import java.util.*;

public class BorrowService {
    public static void borrowBook(Map<String, Book> books, User user, Scanner sc) throws Exception {
        if (user.borrowedBooks.size() >= 3) {
            System.out.println("You already borrowed 3 books!");
            return;
        }
        if (user.deposit < 500) {
            System.out.println("Minimum deposit of 500 required");
            return;
        }
        System.out.println("Enter ISBN to borrow:");
        String isbn = sc.nextLine();
        if (!books.containsKey(isbn)) return;
        if (user.borrowedBooks.contains(isbn)) {
            System.out.println("Already borrowed this book");
            return;
        }
        if (books.get(isbn).quantity <= 0) {
            System.out.println("Book not available");
            return;
        }
        books.get(isbn).quantity--;
        user.borrowedBooks.add(isbn);
        user.dueDates.put(isbn, getDueDate());
        user.extensionCount.put(isbn, 0);
        System.out.println("Book borrowed. Return by: " + user.dueDates.get(isbn));
    }

    public static String getDueDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 15);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }

    public static void extendBook(User user, Scanner sc) {
        System.out.println("Enter ISBN to extend:");
        String isbn = sc.nextLine();
        if (!user.borrowedBooks.contains(isbn)) return;
        int ext = user.extensionCount.get(isbn);
        if (ext >= 2) {
            System.out.println("Max extension reached");
            return;
        }
        user.extensionCount.put(isbn, ext + 1);
        System.out.println("Book extended. Return by 15 more days.");
    }

    public static void markBookLost(Map<String, Book> books, User user, Scanner sc) {
        System.out.println("Enter ISBN:");
        String isbn = sc.nextLine();
        if (!user.borrowedBooks.contains(isbn)) return;
        double fine = books.get(isbn).cost * 0.5;
        user.deposit -= fine;
        user.fineHistory.add("Lost book fine: " + isbn + " = Rs. " + fine);
        user.borrowedBooks.remove(isbn);
        books.get(isbn).quantity--;
        System.out.println("Marked as lost. Fine: Rs. " + fine);
    }

    public static void cardLost(User user) {
        user.deposit -= 10;
        user.fineHistory.add("Card lost fine = Rs. 10");
        System.out.println("Rs. 10 deducted for card loss");
    }
}
