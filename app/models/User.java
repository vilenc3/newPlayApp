package models;

import java.util.HashSet;
import java.util.Set;

public class User {
    public Integer type; // 1->admin, 2->standard
    public String email;
    public String password;
    public String name;

    public Set<Book> cart;

    public User(){

    }

    public User(int type, String email, String password, String name){
        this.type = type;
        this.email = email;
        this.password = password;
        this.name = name;
        this.cart = new HashSet<>();
    }

    public Set<Book> getCart(){
        return cart;
    }

    public void add(Book book){
        cart.add(book);
    }
}
