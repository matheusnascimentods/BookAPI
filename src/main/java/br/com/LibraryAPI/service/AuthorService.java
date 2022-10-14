package br.com.LibraryAPI.service;

import br.com.LibraryAPI.dto.AuthorDTO;
import br.com.LibraryAPI.model.Author;
import br.com.LibraryAPI.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {

        this.repository = repository;

    }

    public List<AuthorDTO> get() {

        return AuthorDTO.toDTO(repository.findAll());

    }

    public ResponseEntity<AuthorDTO> getById(Long id) {

        Author author = repository.findById(id).get();
        return ResponseEntity.ok().body(new AuthorDTO(author));

    }

    public ResponseEntity<AuthorDTO> post(AuthorDTO authorDTO, UriComponentsBuilder uriBuilder) {

        Author authorEntity = authorDTO.toModel();

        repository.save(authorEntity);
        URI uri = uriBuilder.path("/Author/{id}").buildAndExpand(authorEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(new AuthorDTO(authorEntity));

    }

    public void delete(Long id) {

        repository.deleteById(id);

    }

    public ResponseEntity<AuthorDTO> patch(Long id, AuthorDTO authorDTO) {

        Author author = repository.findById(id).get();
            author.setName(authorDTO.getName());
            author.setAge(authorDTO.getAge());

        repository.save(author);

        return ResponseEntity.ok().body(new AuthorDTO(author));

    }
}
