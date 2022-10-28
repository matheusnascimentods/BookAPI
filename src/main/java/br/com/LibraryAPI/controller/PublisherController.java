package br.com.LibraryAPI.controller;

import br.com.LibraryAPI.dto.PublisherDTO;
import br.com.LibraryAPI.repository.PublisherRepository;
import br.com.LibraryAPI.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController @RequestMapping("Publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository repository;

    @Autowired
    private PublisherService service = new PublisherService(repository);

    @GetMapping
    public List<PublisherDTO> get() {

        return service.get();

    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> getById(@PathVariable Long id) {

        return service.getById(id);

    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED) @Transactional
    public ResponseEntity<PublisherDTO> post(@RequestBody @Valid PublisherDTO publisherDTO, UriComponentsBuilder uri) {

        return service.post(publisherDTO, uri);

    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) @Transactional
    public void delete(@PathVariable Long id) {

        service.delete(id);

    }

}
