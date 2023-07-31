package org.example.service;

import org.example.entity.Author;

import java.util.List;

public interface AuthorService {
    String saveAuthor(Author author);
    String updateAuthor(Long id , Author author);

    Author getAuthorById(Long id);

    List<Author> getAuthorByPublisherId(Long id);

    String deleteAuthor(Long id);

    String assignAuthorToPublisher(Long AuthorId,Long PublisherId);
}
