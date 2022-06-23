package com.example.relationship.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;

    private LocalDate releaseDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="BOOK_GENRE",
            joinColumns={@JoinColumn(name="BOOK_ID")},
            inverseJoinColumns={@JoinColumn(name="GENRE_ID")})
    private List<Genre> genres;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Author> authors;
}
