package br.com.LibraryAPI.model;

import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "Books")
@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
@Data
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false) @NonNull
    private String title;

    @Column(nullable = false) @NonNull
    private String description;

    @Column(columnDefinition = "Integer default 0") @NonNull
    private int pages;

    @Column(columnDefinition = "Integer default 0") @NonNull
    private int chapters;

    @ManyToOne(cascade = {CascadeType.MERGE}) @NonNull
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE}) @NonNull
    private Publisher publisher;

}
