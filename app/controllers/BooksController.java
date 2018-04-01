package controllers;
import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.filters.csrf.CSRF;
import play.mvc.Result;
import play.mvc.Controller;
import java.util.Set;
import javax.inject.Inject;
import views.html.books.*;
import views.html.books.index;

//import views.html.index;

public class BooksController extends Controller{

    @Inject
    FormFactory formFactory;

    public Result index(){
        Set<Book> books = Book.retrieveAll();
        return ok(index.render(books));
    }

    public Result cart(){
        Set<Book> books = Book.retrieveCart();
        return ok(cart.render(books));
    }

    public Result addToCart(Integer id){
        Book book = Book.retrieveById(id);
        Book.addtoCart(book);
        return redirect(routes.BooksController.index());
    }

    public Result create(){
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(create.render(bookForm));
    }

    public Result clearCart(){
        Book.clearCart();
        return redirect(routes.BooksController.index());
    }

    public Result save(){
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        Book.add(book);
        return redirect(routes.BooksController.index());
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

        return redirect(routes.BooksController.index());
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
        return redirect(routes.BooksController.index());
    }

    public Result deleteFromCart(Integer id){
        Book book = Book.retrieveById(id);
        if (book == null){
            return notFound("Book not found");
        }
        Book.removeFromCart(book);
        return redirect(routes.BooksController.cart());
    }
}
