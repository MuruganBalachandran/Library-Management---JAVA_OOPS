
import auth.AuthService;
import auth.User;
import inventory.Book;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Map<String, User> users = new HashMap<>();
    static Map<String, Book> books = new HashMap<>();
    
    public static void main(String[] args) throws Exception {
        preloadData();
        System.out.println("Enter Email:");
        String email = sc.nextLine();
        System.out.println("Enter Password:");
        String pass = sc.nextLine();

        if (!users.containsKey(email) || !users.get(email).password.equals(pass)) {
            System.out.println("Invalid Credentials!");
            return;
        }

        User currentUser = users.get(email);
        if (currentUser.role.equals("admin")) AuthService.adminMenu(currentUser, users, books, sc);
        else AuthService.borrowerMenu(currentUser, books, sc);
    }

    static void preloadData() {
        users.put("admin@mail.com", new User("admin@mail.com", "admin123", "admin"));
        users.put("user@mail.com", new User("user@mail.com", "user123", "borrower"));
          users.put("murugan@mail.com", new User("muugan@mail.com", "murugan", "borrower"));
        users.put("student@mail.com", new User("student@mail.com", "student", "borrower"));
    }
}
