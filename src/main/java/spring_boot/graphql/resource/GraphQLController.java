package spring_boot.graphql.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import spring_boot.graphql.model.Author;
import spring_boot.graphql.model.Book;
import spring_boot.graphql.service.AuthorService;
import spring_boot.graphql.service.BookService;

@Controller
public class GraphQLController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @QueryMapping
    Iterable<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @QueryMapping
    Iterable<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    Author getAuthor(@Argument long id) {
        return authorService.getAuthorById(id);
    }

    @QueryMapping
    Book getBook(@Argument long id) {
        return bookService.getBookById(id);
    }
}
