package org.example.repo;

import org.example.entity.Book;

public interface BookRepo {
    String saveBook(Book book,Long authorId);
    String  updateBook(Long id , Book book);
    Book getBookAndPublisherByBookId(Long bookId);
    String deleteBookByAuthorId(Long authorId);
}
