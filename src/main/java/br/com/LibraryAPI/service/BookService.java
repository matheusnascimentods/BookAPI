package br.com.LibraryAPI.service;

import br.com.LibraryAPI.dto.BookRequestDTO;
import br.com.LibraryAPI.dto.BookResponseDTO;
import br.com.LibraryAPI.model.Author;
import br.com.LibraryAPI.model.Book;
import br.com.LibraryAPI.model.Publisher;
import br.com.LibraryAPI.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository repository;
    private AuthorService authorService;
    private PublisherService publisherService;

    public BookService(br.com.LibraryAPI.repository.BookRepository bookRepository, AuthorService authorService, PublisherService publisherService) {

        this.repository = bookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;

    }

    public ResponseEntity<BookResponseDTO> post(BookRequestDTO requestDTO) {

        Author author = authorService.getById(requestDTO.getAuthorId()).getBody().modelToBook();
        Publisher publisher = publisherService.getById(requestDTO.getPublisherId()).getBody().modelToBook();

        Book book = requestDTO.toModel(author, publisher);

        repository.save(book);

    }

}
