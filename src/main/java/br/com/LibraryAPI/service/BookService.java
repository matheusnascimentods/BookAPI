package br.com.LibraryAPI.service;

import br.com.LibraryAPI.dto.BookRequestDTO;
import br.com.LibraryAPI.mapper.BookMapper;
import br.com.LibraryAPI.model.Author;
import br.com.LibraryAPI.model.Book;
import br.com.LibraryAPI.model.Publisher;
import br.com.LibraryAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final static BookMapper mapper = BookMapper.INTANCE;

    private BookRepository repository;
    private AuthorService authorService;
    private PublisherService publisherService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService, PublisherService publisherService) {

        this.repository = bookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;

    }

    public void post(BookRequestDTO requestDTO) {

        Author author = authorService.verifyIfExistsAndGet(requestDTO.getAuthorId());
        Publisher publisher = publisherService.verifyIfExistsAndGet(requestDTO.getPublisherId());

        Book bookToCreate = mapper.toModel(requestDTO);
            bookToCreate.setAuthor(author);
            bookToCreate.setPublisher(publisher);


        Book createdBook = repository.save(bookToCreate);

    }

}
