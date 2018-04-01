package models;

import java.util.HashSet;
import java.util.Set;


public class Book {
    public Integer id;
    public String title;
    public Integer price;
    public String author;

    public Book(){

    }

    public Book(Integer id, String title, Integer price, String author){
        this.id = id;
        this.title=title;
        this.price=price;
        this.author=author;
    }

    private static Set<Book> books;
    private static Set<Book> cart;

    static {
        books = new HashSet<>();
        cart = new HashSet<>();
        books.add(new Book(1, "The Trial", 20, "Franz Kafka"));
        books.add(new Book(2, "Silmarillion", 15, "J R R Tolkien"));
        books.add(new Book(3, "The Odyssey", 25, "Homer"));
        books.add(new Book(4, "War and Peace", 30, "Leo Tolstoy"));
    }

    public static Set<Book> retrieveAll(){
        return books;
    }

    public static Set<Book> retrieveCart(){
        return cart;
    }

    public static void clearCart(){
        cart = new HashSet<>();
    }

    public static Book retrieveById(Integer id) {
        for (Book book : books) {
            if (id.equals(book.id)) {
                return book;
            }
        }
    return null;
    }

    public static void add(Book book){
        books.add(book);
    }

    public static void addtoCart(Book book){
        cart.add(book);
    }

    public static boolean remove(Book book){
        return books.remove(book);
    }
    public static boolean removeFromCart(Book book){
        return cart.remove(book);
    }
}
