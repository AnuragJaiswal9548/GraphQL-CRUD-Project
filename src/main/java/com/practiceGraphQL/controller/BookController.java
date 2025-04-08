package com.practiceGraphQL.controller;

import com.practiceGraphQL.entities.Book;
import com.practiceGraphQL.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @QueryMapping("getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping("getBookById")
    public Book getBookById(@Argument Long id) {
        return bookService.findById(id).orElse(null);
    }

    @MutationMapping("createBook")
    public Book createBook(@Argument String title,
                           @Argument String author,
                           @Argument int pages) {
        return bookService.createBook(title, author, pages);
    }

    @MutationMapping("updateBook")
    public Book updateBook(@Argument Long id,
                           @Argument String title,
                           @Argument String author,
                           @Argument int pages) {
        return bookService.updateBook(id, title, author, pages);
    }

    @MutationMapping("deleteById")
    public Boolean deleteById(@Argument Long id) {
        return bookService.deleteBook(id);
    }

}
