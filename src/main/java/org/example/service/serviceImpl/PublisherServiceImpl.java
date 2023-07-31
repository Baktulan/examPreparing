package org.example.service.serviceImpl;

import org.example.entity.Publisher;
import org.example.repo.PublisherRepo;
import org.example.repo.repoImpl.PublisherRepoImpl;
import org.example.service.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    PublisherRepo publisherRepo = new PublisherRepoImpl();

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepo.savePublisher(publisher);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepo.getPublisherById(id);
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return publisherRepo.getAllPublisher();
    }

    @Override
    public String updatePublisher(Long id, Publisher publisher) {
        return publisherRepo.updatePublisher(id,publisher);
    }

    @Override
    public String deletePublisherByName(String publisherName) {
        return publisherRepo.deletePublisherByName(publisherName);
    }

    @Override
    public String assignBookToPublisher(Long publisherId, Long bookId) {
        return publisherRepo.assignBookToPublisher(publisherId,bookId);
    }
}
