package org.example.repo.repoImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateDataBase;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repo.BookRepo;

public class BookRepoImpl implements BookRepo {
    public final EntityManager entityManager = HibernateDataBase.getEntityManager();

    @Override
    public String saveBook(Book book, Long authorId) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        Author author = entityManager.createQuery("select a from Author a where a.id=:authorId", Author.class).setParameter("authorId", authorId).getSingleResult();
        book.setAuthor(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book + " is successfully saved";
    }

    @Override
    public String updateBook(Long id, Book book) {
        entityManager.getTransaction().begin();
        Book book1 = entityManager.find(Book.class, id);
        book1.setName(book.getName());
        book1.setPrice(book.getPrice());
        book1.setGenre(book.getGenre());
        book1.setCountry(book.getCountry());
        book1.setPublishedYear(book.getPublishedYear());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Book with " + id + " id successfully updated";
    }

    @Override
    public Book getBookAndPublisherByBookId(Long bookId) {
        entityManager.getTransaction().begin();
        Book bookId1 = entityManager.createQuery("select b  from Book b inner join fetch b.publisher p where b.id=:bookId", Book.class).setParameter("bookId", bookId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return bookId1;
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        entityManager.getTransaction().begin();
        Book book = entityManager.createQuery("select b from Book b inner join b.author a where b.author.id=:authorId", Book.class).setParameter("authorId", authorId).getSingleResult();
        entityManager.remove(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Book with "+ authorId+" id successfully deleted";
    }
}
