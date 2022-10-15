package br.com.LibraryAPI.model;

import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "Books")
@AllArgsConstructor @NoArgsConstructor @Data
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(columnDefinition = "Integer default 0")
    private int pages;

    @Column(columnDefinition = "Integer default 0")
    private int chapters;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Publisher publisher;

}
