package br.com.LibraryAPI.dto;

import br.com.LibraryAPI.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookResponseDTO {

    private long id;

    private String title;

    private String description;

    private Long pages;

    private Long chapters;

    private AuthorDTO author;

    private PublisherDTO publisher;

    public BookResponseDTO(Book book, AuthorDTO author, PublisherDTO publisher) {

        this.id = book.getId();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.pages = Long.valueOf(book.getPages());
        this.chapters = Long.valueOf(book.getChapters());
        this.author = author;
        this.publisher = publisher;
        
    }

    public BookResponseDTO(Book book) {
    }

    public static List<BookResponseDTO> toDTO(List<Book> book) {
        
        return book.stream().map(BookResponseDTO::new).collect(Collectors.toList());
        
    }

}
