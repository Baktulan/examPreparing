package org.example.service;

import org.example.entity.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);

    Publisher getPublisherById(Long id);

    List<Publisher> getAllPublisher();

    String  updatePublisher(Long id , Publisher publisher);

    String deletePublisherByName(String publisherName);
    String assignBookToPublisher(Long publisherId,Long bookId);
}
