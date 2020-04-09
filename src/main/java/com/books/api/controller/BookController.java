package com.books.api.controller;

import com.books.api.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Book[]> getBooks() {
        Book[] books = new Book[1];
        books[0] = new Book().builder().Author("Slava").Title("How to thing").PublishYear(1).ISBN("1234ABC").build();
        return ResponseEntity.ok(books);
    }

}