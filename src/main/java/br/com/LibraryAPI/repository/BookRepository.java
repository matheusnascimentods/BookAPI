package br.com.LibraryAPI.repository;

import br.com.LibraryAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Optional<Book> findByTitle(String name);

}
