package br.com.LibraryAPI.service;

import br.com.LibraryAPI.exception.Exceptions.BookAlreadyExistsException;
import br.com.LibraryAPI.exception.Exceptions.BookNotFoundException;
import br.com.LibraryAPI.dto.BookRequestDTO;
import br.com.LibraryAPI.dto.BookResponseDTO;
import br.com.LibraryAPI.mapper.BookMapper;
import br.com.LibraryAPI.model.Author;
import br.com.LibraryAPI.model.Book;
import br.com.LibraryAPI.model.Publisher;
import br.com.LibraryAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final static BookMapper mapper = BookMapper.INTANCE;

    private final BookRepository repository;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService, PublisherService publisherService) {

        this.repository = bookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    public List<BookResponseDTO> get() {

        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public ResponseEntity<BookResponseDTO> getById(Long id) {

        if (!repository.existsById(id)) {
            throw new BookNotFoundException(id);
        }

        Book book = repository.findById(id).get();
        return ResponseEntity.ok().body(mapper.toDTO(book));
    }

    public ResponseEntity<BookResponseDTO> post(BookRequestDTO requestDTO, UriComponentsBuilder uriBuilder) {

        Author author = authorService.verifyIfExistsAndGet(requestDTO.getAuthorId());
        Publisher publisher = publisherService.verifyIfExistsAndGet(requestDTO.getPublisherId());

        Book bookToCreate = mapper.toModel(requestDTO);
        bookToCreate.setAuthor(author);

        verifyIfExists(bookToCreate.getTitle());

        bookToCreate.setPublisher(publisher);

        Book createdBook = repository.save(bookToCreate);

        URI uri = uriBuilder.path("Book/{id}").buildAndExpand(createdBook.getId()).toUri();
        return ResponseEntity.created(uri).body(mapper.toDTO(createdBook));
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new BookNotFoundException(id);
        }

        repository.deleteById(id);
    }

    public ResponseEntity<BookResponseDTO> put(Long id, BookRequestDTO requestDTO) {

        if (!repository.existsById(id)) {
            throw new BookNotFoundException(id);
        }

        Book book = repository.findById(id).get();
        book.setTitle(requestDTO.getTitle());
        book.setDescription(requestDTO.getDescription());
        book.setPages(Math.toIntExact(requestDTO.getPages()));
        book.setChapters(Math.toIntExact(requestDTO.getChapters()));
        book.setAuthor(authorService.verifyIfExistsAndGet(requestDTO.getAuthorId()));
        book.setPublisher(publisherService.verifyIfExistsAndGet(requestDTO.getPublisherId()));

        Book updatedBook = repository.save(book);

        return ResponseEntity.ok().body(mapper.toDTO(updatedBook));

    }

    public void verifyIfExists(String title) {

        repository.findByTitle(title).ifPresent(book -> { throw new BookAlreadyExistsException(title); });

    }

}