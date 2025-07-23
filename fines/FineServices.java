package fines;

import auth.User;
import inventory.Book;
import java.text.SimpleDateFormat;
import java.util.*;

public class FineServices {
    public static void returnBook(Map<String, Book> books, User user, Scanner sc) throws Exception {
        System.out.println("Enter ISBN:");
        String isbn = sc.nextLine();
        if (!user.borrowedBooks.contains(isbn)) return;
        System.out.println("Enter Return Date (dd/MM/yyyy):");
        String returnDate = sc.nextLine();
        Date due = new SimpleDateFormat("dd/MM/yyyy").parse(user.dueDates.get(isbn));
        Date ret = new SimpleDateFormat("dd/MM/yyyy").parse(returnDate);
        long diff = (ret.getTime() - due.getTime()) / (1000 * 60 * 60 * 24);
        if (diff > 0) {
            double fine = Math.min(80.0 / 100 * books.get(isbn).cost, 2 * diff + (diff / 10) * 5);
            user.deposit -= fine;
            user.fineHistory.add("Late return fine for ISBN: " + isbn + " = Rs. " + fine);
            System.out.println("Late return fine: " + fine);
        }
        books.get(isbn).quantity++;
        user.borrowedBooks.remove(isbn);
        user.dueDates.remove(isbn);
    }

    public static void viewFineHistory(User user) {
        for (String fine : user.fineHistory)
            System.out.println(fine);
    }
}
