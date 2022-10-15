package br.com.LibraryAPI.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity @Table(name="Authors")
@NoArgsConstructor @AllArgsConstructor@Data
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @Column(columnDefinition = "Integer default 0")
    private int age;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;


}
