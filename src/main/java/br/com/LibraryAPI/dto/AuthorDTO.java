package br.com.LibraryAPI.dto;

import br.com.LibraryAPI.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor @NoArgsConstructor @Data
public class AuthorDTO {

    private long id;
    @NotNull @NotEmpty @Size(max = 205)
    private String name;

    @NotNull
    private int age;

    public AuthorDTO(Author author) {

        this.id = author.getId();
        this.name = author.getName();
        this.age = author.getAge();

    }

    public static List<AuthorDTO> toDTO(List<Author> authors) {

        return authors.stream().map(AuthorDTO::new).collect(Collectors.toList());

    }

    public Author toModel() {

        return new Author(this.name, this.age);

    }

    public Author modelToBook() {

        Author author = new Author(this.name, this.age);
        author.setId(this.id);

        return author;

    }

}
