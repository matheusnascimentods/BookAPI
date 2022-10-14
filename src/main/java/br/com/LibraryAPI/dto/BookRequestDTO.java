package br.com.LibraryAPI.dto;

import br.com.LibraryAPI.model.Author;
import br.com.LibraryAPI.model.Book;
import br.com.LibraryAPI.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookRequestDTO {

    private long id;

    @NotNull @NotEmpty @Size(max = 225)
    private String title;

    @NotNull @NotEmpty @Size(max = 550)
    private String description;

    @NotNull @Max(3000)
    private Long pages;

    @NotNull @Max(200)
    private Long chapters;

    @NotNull
    private Long authorId;

    @NotNull
    private Long publisherId;

    public Book toModel(Author author, Publisher publisher) {

        return new Book(this.title, this.description, Math.toIntExact(this.pages), Math.toIntExact(this.chapters), author, publisher);

    }

}
