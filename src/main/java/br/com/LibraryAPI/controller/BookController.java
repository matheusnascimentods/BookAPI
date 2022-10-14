package br.com.LibraryAPI.controller;

import br.com.LibraryAPI.dto.BookRequestDTO;
import br.com.LibraryAPI.repository.AuthorRepository;
import br.com.LibraryAPI.repository.BookRepository;
import br.com.LibraryAPI.repository.PublisherRepository;
import br.com.LibraryAPI.service.AuthorService;
import br.com.LibraryAPI.service.BookService;
import br.com.LibraryAPI.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("Book")
public class BookController {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookService service = new BookService(repository, new AuthorService(authorRepository), new PublisherService(publisherRepository));

    @PostMapping
    public void post(@RequestBody BookRequestDTO requestDTO) {

        service.post(requestDTO);

    }

}
