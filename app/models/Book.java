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
        books.add(new Book(1, "BookTitle", 20, "ABCD"));
        books.add(new Book(2, "BookNewTitle", 30, "DBCD"));
    }

    public static Set<Book> retrieveAll(){
        return books;
    }

    public static Set<Book> retrieveCart(){
        return cart;
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
}
