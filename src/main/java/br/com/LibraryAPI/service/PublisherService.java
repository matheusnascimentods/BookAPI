package br.com.LibraryAPI.service;

import br.com.LibraryAPI.dto.PublisherDTO;
import br.com.LibraryAPI.model.Publisher;
import br.com.LibraryAPI.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class PublisherService {

    private PublisherRepository repository;

    @Autowired
    public PublisherService(PublisherRepository repository) {

        this.repository = repository;

    }

    public List<PublisherDTO> get() {

        return PublisherDTO.toDTO(repository.findAll());

    }

    public ResponseEntity<PublisherDTO> getById(Long id) {

        Publisher publisher = repository.findById(id).get();
        return ResponseEntity.ok().body(new PublisherDTO(publisher));

    }

    public ResponseEntity<PublisherDTO> post(PublisherDTO publisherDTO, UriComponentsBuilder uriBuilder) {

        Publisher publisher = publisherDTO.toModel();
        repository.save(publisher);

        URI uri = uriBuilder.path("/Publisher/{id}").buildAndExpand(publisher.getId()).toUri();

        return ResponseEntity.created(uri).body(new PublisherDTO(publisher));

    }

    public void delete(Long id) {

        repository.deleteById(id);

    }

    public ResponseEntity<PublisherDTO> put(Long id, PublisherDTO publisher) {

        Publisher publisherModel = repository.findById(id).get();
            publisherModel.setName(publisher.getName());

        repository.save(publisherModel);

        return ResponseEntity.ok().body(new PublisherDTO(publisherModel));

    }
}
