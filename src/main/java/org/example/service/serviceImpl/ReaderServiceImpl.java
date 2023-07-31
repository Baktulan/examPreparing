package org.example.service.serviceImpl;

import org.example.entity.Reader;
import org.example.repo.ReaderRepo;
import org.example.repo.repoImpl.ReaderRepoImpl;
import org.example.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    ReaderRepo readerRepo= new ReaderRepoImpl();
    @Override
    public String saveReader(Reader reader) {
        return readerRepo.saveReader(reader);
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        return readerRepo.updateReader(id,reader);
    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        return readerRepo.getReaderByBookId(bookId);
    }

    @Override
    public String deleteReaderById(Long id) {
        return readerRepo.deleteReaderById(id);
    }

    @Override
    public Reader getReaderByAuthorId(Long authorId) {
        return readerRepo.getReaderByAuthorId(authorId);
    }

    @Override
    public String assignBookToReader(Long readerId, Long bookId) {
        return readerRepo.assignBookToReader(readerId,bookId);
    }
}
