package br.com.LibraryAPI.controller;

import br.com.LibraryAPI.dto.AuthorDTO;
import br.com.LibraryAPI.repository.AuthorRepository;
import br.com.LibraryAPI.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController @RequestMapping("Author")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private AuthorService service = new AuthorService(repository);

    @GetMapping
    public List<AuthorDTO> get() {

        return service.get();

    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getById(@PathVariable Long id) {

        return service.getById(id);

    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthorDTO> post(@RequestBody @Valid AuthorDTO author, UriComponentsBuilder uri) {

        return service.post(author, uri);

    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        service.delete(id);

    }

}
