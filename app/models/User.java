package models;

import java.util.HashSet;
import java.util.Set;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User extends Model{
    @Id
    public Integer id;
    public Integer type;
    public String username;
    public String email;
    public String password;


    public static Finder<Integer, User> find = new Finder<>(User.class);

    public Set<Book> cart;
    public static Set<User> users;

    public Set<Book> getCart(){
        return cart;
    }

    public void add(Book book){
        cart.add(book);
    }
}
