package br.com.LibraryAPI.repository;

import br.com.LibraryAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
