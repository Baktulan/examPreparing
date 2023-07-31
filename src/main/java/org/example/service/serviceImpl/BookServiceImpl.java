package org.example.service.serviceImpl;

import org.example.entity.Book;
import org.example.repo.BookRepo;
import org.example.repo.repoImpl.BookRepoImpl;
import org.example.service.BookService;

public class BookServiceImpl implements BookService {
    BookRepo bookRepo = new BookRepoImpl();
    @Override
    public String saveBook(Book book,Long authorId) {
        return bookRepo.saveBook(book,authorId );
    }

    @Override
    public String updateBook(Long id, Book book) {
        return bookRepo.updateBook(id,book);
    }

    @Override
    public Book getBookAndPublisherByBookId(Long bookId) {
        return bookRepo.getBookAndPublisherByBookId(bookId);
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        return bookRepo.deleteBookByAuthorId(authorId);
    }
}
