package org.example.service;

import org.example.entity.Book;

public interface BookService {
    String saveBook(Book book,Long authorId);

    String  updateBook(Long id , Book book);

    Book getBookAndPublisherByBookId(Long bookId);

    String deleteBookByAuthorId(Long authorId);
}
