package org.example.service.serviceImpl;

import org.example.entity.Author;
import org.example.repo.AuthorRepo;
import org.example.repo.repoImpl.AuthorRepoImpl;
import org.example.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepo authorRepo= new AuthorRepoImpl();
    @Override
    public String saveAuthor(Author author){
        return authorRepo.saveAuthor(author);
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        return authorRepo.updateAuthor(id,author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepo.getAuthorById(id);
    }

    @Override
    public List<Author> getAuthorByPublisherId(Long id) {
        return authorRepo.getAuthorByPublisherId(id);
    }

    @Override
    public String deleteAuthor(Long id) {
        return authorRepo.deleteAuthor(id);
    }

    @Override
    public String assignAuthorToPublisher(Long AuthorId, Long PublisherId) {
        return authorRepo.assignAuthorToPublisher(AuthorId,PublisherId);
    }
}
