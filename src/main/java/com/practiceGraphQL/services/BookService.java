package com.practiceGraphQL.services;

import com.practiceGraphQL.entities.Book;
import com.practiceGraphQL.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(String title, String author, int pages) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPages(pages);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, String title, String author, int pages) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(title);
        book.setPages(pages);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public Boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
