package inventory;

public class Book {
    public String name, isbn;
    public int quantity;
    public double cost;

    public Book(String name, String isbn, int quantity, double cost) {
        this.name = name;
        this.isbn = isbn;
        this.quantity = quantity;
        this.cost = cost;
    }
}