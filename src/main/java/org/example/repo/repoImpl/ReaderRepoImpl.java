package org.example.repo.repoImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateDataBase;
import org.example.entity.Book;
import org.example.entity.Reader;
import org.example.repo.ReaderRepo;

public class ReaderRepoImpl implements ReaderRepo {
    public final EntityManager entityManager = HibernateDataBase.getEntityManager();

    @Override
    public String saveReader(Reader reader) {
        entityManager.getTransaction().begin();
        entityManager.persist(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader +" is successfully saved";
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        entityManager.getTransaction().begin();
        Reader reader1 = entityManager.find(Reader.class, id);
        reader1.setName(reader.getName());
        reader1.setEmail(reader.getEmail());
        reader1.setAge(reader.getAge());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Reader with "+ id +" id successfully updated to "+reader;
    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.createQuery("select r from Reader  r inner join r.book b where b.id=:bookId", Reader.class).setParameter("bookId", bookId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader;
    }

    @Override
    public String deleteReaderById(Long id) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class, id);
        entityManager.remove(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader+" successfully deleted";
    }

    @Override
    public Reader getReaderByAuthorId(Long authorId) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.createQuery("select r from Reader r inner join r.book b inner join b.author a where r.book.author.id=:authorId", Reader.class).setParameter("authorId", authorId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader;
    }

    @Override
    public String assignBookToReader(Long readerId, Long bookId) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);
        Reader reader = entityManager.find(Reader.class, readerId);
        reader.setBook(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully assigned";
    }
}
