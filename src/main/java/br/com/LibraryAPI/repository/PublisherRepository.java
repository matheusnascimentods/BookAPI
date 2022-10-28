package br.com.LibraryAPI.repository;

import br.com.LibraryAPI.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    public Optional<Publisher> findByName(String name);

}
