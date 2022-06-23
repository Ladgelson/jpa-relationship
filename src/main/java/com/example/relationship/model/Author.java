package com.example.relationship.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String nickname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="BOOK_AUTHOR",
            joinColumns={@JoinColumn(name="AUTHOR_ID")},
            inverseJoinColumns={@JoinColumn(name="BOOK_ID")})
    private List<Book> books;

    @OneToOne(mappedBy = "author")
    private Person person;
}
