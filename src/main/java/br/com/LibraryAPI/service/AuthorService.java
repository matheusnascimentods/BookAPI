package br.com.LibraryAPI.service;

import br.com.LibraryAPI.exception.Exceptions.AuthorAlreadyExistsException;
import br.com.LibraryAPI.exception.Exceptions.AuthorNotFoundException;
import br.com.LibraryAPI.dto.AuthorDTO;
import br.com.LibraryAPI.mapper.AuthorMapper;
import br.com.LibraryAPI.model.Author;
import br.com.LibraryAPI.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository repository;
    private final static AuthorMapper mapper = AuthorMapper.INSTANCE;

    @Autowired
    public AuthorService(AuthorRepository repository) {

        this.repository = repository;

    }

    public List<AuthorDTO> get() {

        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());

    }

    public ResponseEntity<AuthorDTO> getById(Long id) {

        if (!repository.existsById(id)) {
            throw new AuthorNotFoundException(id);
        }

        Author author = repository.findById(id).get();
        return ResponseEntity.ok().body(mapper.toDTO(author));
    }

    public ResponseEntity<AuthorDTO> post(AuthorDTO authorDTO, UriComponentsBuilder uriBuilder) {

        Author authorToSave = mapper.toModel(authorDTO);
        verifyIfExists(authorToSave.getName());

        Author createdAuthor = repository.save(authorToSave);

        URI uri = uriBuilder.path("/Author/{id}").buildAndExpand(createdAuthor.getId()).toUri();
        return ResponseEntity.created(uri).body(mapper.toDTO(createdAuthor));

    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new AuthorNotFoundException(id);
        }

        repository.deleteById(id);
    }

    public Author verifyIfExistsAndGet(Long id) {

        return repository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

    }

    public void verifyIfExists(String name) {

        repository.findByName(name).ifPresent(author -> { throw new AuthorAlreadyExistsException(name); });
    }

}
