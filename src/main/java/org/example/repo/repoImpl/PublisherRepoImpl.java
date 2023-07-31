package org.example.repo.repoImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateDataBase;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repo.PublisherRepo;

import java.util.ArrayList;
import java.util.List;

public class PublisherRepoImpl implements PublisherRepo {
    public final EntityManager entityManager = HibernateDataBase.getEntityManager();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.id=:id", Publisher.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllPublisher() {
        entityManager.getTransaction().begin();
        List<Publisher>publishers= new ArrayList<>();
        publishers=entityManager.createQuery("select p from Publisher  p order by p.name", Publisher.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publishers;
    }

    @Override
    public String updatePublisher(Long id, Publisher publisher) {
        entityManager.getTransaction().begin();
        Publisher publisher1 = entityManager.createQuery("select p from Publisher p where p.id=:id", Publisher.class).setParameter("id", id).getSingleResult();
        publisher1.setName(publisher.getName());
        publisher1.setAddress(publisher.getAddress());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "publisher with "+ id+" id successfully updated";
    }

    @Override
    public String deletePublisherByName(String publisherName) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.name=:publisherName ", Publisher.class).setParameter("publisherName", publisherName).getSingleResult();
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Publisher  "+ publisherName+"  successfully deleted";
    }

    @Override
    public String assignBookToPublisher(Long publisherId, Long bookId) {
        List<Publisher>publishers= new ArrayList<>();
        List<Book>books=new ArrayList<>();
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        Book book = entityManager.find(Book.class, bookId);
        publishers.add(publisher);
        books.add(book);
        publisher.setBooks(books);
        book.setPublisher(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully assigned";
    }
}
