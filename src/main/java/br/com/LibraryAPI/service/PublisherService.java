package br.com.LibraryAPI.service;

import br.com.LibraryAPI.exception.Exceptions.PublisherAlreadyExistsException;
import br.com.LibraryAPI.exception.Exceptions.PublisherNotFoundException;
import br.com.LibraryAPI.dto.PublisherDTO;
import br.com.LibraryAPI.mapper.PublisherMapper;
import br.com.LibraryAPI.model.Publisher;
import br.com.LibraryAPI.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final PublisherRepository repository;
    private final static PublisherMapper mapper = PublisherMapper.INSTANCE;

    @Autowired
    public PublisherService(PublisherRepository repository) {

        this.repository = repository;

    }

    public List<PublisherDTO> get() {

        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());

    }

    public ResponseEntity<PublisherDTO> getById(Long id) {

        Publisher publisher = repository.findById(id).orElseThrow(() -> new PublisherNotFoundException(id));
        return ResponseEntity.ok().body(mapper.toDTO(publisher));

    }

    public ResponseEntity<PublisherDTO> post(PublisherDTO publisherDTO, UriComponentsBuilder uriBuilder) {

        Publisher publisheToCreate = mapper.toModel(publisherDTO);
        verifyIfExists(publisheToCreate.getName());

        Publisher createdPublisher = repository.save(publisheToCreate);

        URI uri = uriBuilder.path("Authors/{id}").buildAndExpand(createdPublisher.getId()).toUri();
        return ResponseEntity.created(uri).body(mapper.toDTO(createdPublisher));

    }

    public void delete(Long id) {

        verifyIfExistsAndGet(id);
        repository.deleteById(id);

    }

    public Publisher verifyIfExistsAndGet(Long id) {

        return repository.findById(id).orElseThrow(() -> new PublisherNotFoundException(id));

    }

    public void verifyIfExists(String name) {

        repository.findByName(name).ifPresent(publisher -> { throw new PublisherAlreadyExistsException(name); });

    }

}
