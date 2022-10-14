package br.com.LibraryAPI.repository;

import br.com.LibraryAPI.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {}
