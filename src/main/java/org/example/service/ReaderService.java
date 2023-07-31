package org.example.service;

import org.example.entity.Reader;

public interface ReaderService {
    String saveReader(Reader reader);
    String updateReader(Long id,Reader reader);
    Reader getReaderByBookId(Long bookId);
    String deleteReaderById(Long id);
    Reader getReaderByAuthorId(Long authorId);

    String assignBookToReader(Long readerId, Long bookId);

}
