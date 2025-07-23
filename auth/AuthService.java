package auth;

import borrow.BorrowService;
import fines.FineServices;
import inventory.Book;
import inventory.InventoryService;
import java.util.*;
import reports.ReportServices;

public class AuthService {
    public static void preloadData(Map<String, User> users) {
        users.put("admin@mail.com", new User("admin@mail.com", "admin123", "admin"));
        users.put("user@mail.com", new User("user@mail.com", "user123", "borrower"));
    }

    public static User authenticate(Map<String, User> users, String email, String pass) {
        if (!users.containsKey(email) || !users.get(email).password.equals(pass)) return null;
        return users.get(email);
    }

    public static void adminMenu(User admin, Map<String, User> users, Map<String, Book> books, Scanner sc) {
        while (true) {
            System.out.println("\n1. Add Book\n2. Modify Book\n3. Delete Book\n4. View Books\n5. Search Book\n6. Add User\n7. Reports\n8. Logout");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> InventoryService.addBook(books, sc);
                case 2 -> InventoryService.modifyBook(books, sc);
                case 3 -> InventoryService.deleteBook(books, sc);
                case 4 -> InventoryService.viewBooks(books);
                case 5 -> InventoryService.searchBook(books, sc);
                case 6 -> addUser(users, sc);
                case 7 -> ReportServices.adminReports(users, books);
                default -> {
                    return;
                }
            }
        }
    }

    public static void borrowerMenu(User user, Map<String, Book> books, Scanner sc) throws Exception {
        while (true) {
            System.out.println("\n1. View Books\n2. Borrow Book\n3. Return Book\n4. Extend Book\n5. Lost Book\n6. Card Lost\n7. View Fine History\n8. Logout");
            int choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1 -> InventoryService.viewBooks(books);
                case 2 -> BorrowService.borrowBook(books, user, sc);
                case 3 -> FineServices.returnBook(books, user, sc);
                case 4 -> BorrowService.extendBook(user, sc);
                case 5 -> BorrowService.markBookLost(books, user, sc);
                case 6 -> BorrowService.cardLost(user);
                case 7 -> FineServices.viewFineHistory(user);
                default -> {
                    return;
                }
            }
        }
    }

    public static void addUser(Map<String, User> users, Scanner sc) {
        System.out.println("Enter Email:");
        String email = sc.nextLine();
        System.out.println("Enter Password:");
        String pass = sc.nextLine();
        System.out.println("Enter Role (admin/borrower):");
        String role = sc.nextLine();
        users.put(email, new User(email, pass, role));
        System.out.println("User added successfully.");
    }
}