package org.example.repo;

import org.example.entity.Publisher;

import java.util.List;

public interface PublisherRepo {
    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublisher();
    String  updatePublisher(Long id , Publisher publisher);
    String deletePublisherByName(String publisherName);
    String assignBookToPublisher(Long publisherId,Long bookId);
}
