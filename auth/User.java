package auth;

import java.util.*;

public class User {
    public String email, password, role;
    public double deposit = 1500;
    public Set<String> borrowedBooks = new HashSet<>();
    public Map<String, String> dueDates = new HashMap<>();
    public Map<String, Integer> extensionCount = new HashMap<>();
    public List<String> fineHistory = new ArrayList<>();

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}