package br.com.LibraryAPI.controller;

import br.com.LibraryAPI.dto.BookRequestDTO;
import br.com.LibraryAPI.dto.BookResponseDTO;
import br.com.LibraryAPI.repository.AuthorRepository;
import br.com.LibraryAPI.repository.BookRepository;
import br.com.LibraryAPI.repository.PublisherRepository;
import br.com.LibraryAPI.service.AuthorService;
import br.com.LibraryAPI.service.BookService;
import br.com.LibraryAPI.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController @RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookService service = new BookService(repository, new AuthorService(authorRepository), new PublisherService(publisherRepository));

    @GetMapping
    public List<BookResponseDTO> get() {

        return service.get();

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getById(@PathVariable Long id) {

        return service.getById(id);

    }

    @PostMapping @Transactional
    public ResponseEntity<BookResponseDTO> post(@RequestBody @Valid BookRequestDTO requestDTO, UriComponentsBuilder uri) {

        return service.post(requestDTO, uri);

    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Transactional
    public void delete(@PathVariable Long id) {

        service.delete(id);

    }

    @PutMapping("/{id}") @Transactional
    public ResponseEntity<BookResponseDTO> put(@PathVariable Long id, @RequestBody BookRequestDTO requestDTO) {

        return service.put(id, requestDTO);

    }

}
