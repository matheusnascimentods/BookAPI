package br.com.LibraryAPI.repository;

import br.com.LibraryAPI.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {}
