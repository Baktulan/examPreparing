package org.example.repo.repoImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateDataBase;
import org.example.entity.Author;
import org.example.entity.Publisher;
import org.example.repo.AuthorRepo;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepoImpl implements AuthorRepo {
    public final EntityManager entityManager = HibernateDataBase.getEntityManager();
    @Override
    public String saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author+" is successfully saved";
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        entityManager.getTransaction().begin();
        Author author1 = entityManager.createQuery("select a from Author a where a.id=:id", Author.class).setParameter("id", id).getSingleResult();
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        author1.setDataOfBirth(author.getDataOfBirth());
        author1.setCountry(author.getCountry());
        author1.setGender(author.getGender());
        author1.setEmail(author.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated";
    }

    @Override
    public Author getAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.createQuery("select a from Author a where a.id=:id", Author.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public List<Author> getAuthorByPublisherId(Long id) {
        entityManager.getTransaction().begin();
        List<Author>authors = entityManager.createQuery("select a from Author a inner join  a.publishers p where p.id=:id", Author.class).setParameter("id", id).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return authors;
    }

    @Override
    public String deleteAuthor(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class,id);
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Author with "+ id +" id successfully deleted";
    }

    @Override
    public String assignAuthorToPublisher(Long AuthorId, Long PublisherId) {
        List<Publisher> publishers= new ArrayList<>();
        List<Author>authors= new ArrayList<>();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, AuthorId);
        Publisher publisher = entityManager.find(Publisher.class, PublisherId);
       publishers.add(publisher);
       authors.add(author);
       author.setPublishers(publishers);
       publisher.setAuthors(authors);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully assigned";
    }
}
