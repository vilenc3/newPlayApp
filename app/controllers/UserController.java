package controllers;

import models.Book;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.books.create;
import views.html.books.edit;
import views.html.books.index;
import views.html.books.show;

import javax.inject.Inject;
import java.util.Set;

//import views.html.index;

public class UserController extends Controller{
    /* * /
    @Inject
    FormFactory formFactory;
    /* * /
    public Result index(User u){
        Set<Book> cart = u.getCart();
        return ok(index.render(cart));
    }

    public Result create(){
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(create.render(bookForm));
    }

    public Result save(User u){
        Book book = bookForm.get();
        u.cart.add(book);
        return redirect(UserController.index());
    }

    public Result edit(Integer id){
        Book book = Book.retrieveById(id);
        if (book==null){
            return notFound("Book not found!");
        }
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);
        return ok(edit.render(bookForm));
    }

    public Result update(){
        Book book = formFactory.form(Book.class).bindFromRequest().get();
        Book oldBook = Book.retrieveById(book.id);
        if (oldBook == null){
            return notFound("Book not found!");
        }
        oldBook.title = book.title;
        oldBook.price = book.price;
        oldBook.author = book.author;

        return redirect(UserController.index());
    }

    public Result show(Integer id){
        Book book = Book.retrieveById(id);
        if (book == null) {
            return notFound("Book not found");
        }
        return ok(show.render(book));
    }

    public Result delete(Integer id){
        Book book = Book.retrieveById(id);
        if (book == null){
            return notFound("Book not found");
        }
        Book.remove(book);
        return redirect(UserController.index());
    }
    /* */
}
