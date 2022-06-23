package com.example.relationship.config;

import com.example.relationship.model.*;
import com.example.relationship.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@AllArgsConstructor
@Slf4j
public class Seeding implements CommandLineRunner {

    private final BookRepository bookRepository;

    private final GenreRepository genreRepository;

    private final AuthorRepository authorRepository;

    private final PhysicalPersonRepository physicalPersonRepository;

    private final BusinessPersonRepository businessPersonRepository;

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) {
        personRepository.deleteAll();
        bookRepository.deleteAll();
        genreRepository.deleteAll();
        authorRepository.deleteAll();
        physicalPersonRepository.deleteAll();
        businessPersonRepository.deleteAll();

        Author micaias = new Author();
        micaias.setNickname("Ladgelson");

        Author russo = new Author();
        micaias.setNickname("Russo");

        PhysicalPerson physicalPerson = new PhysicalPerson();
        physicalPerson.setAuthor(micaias);
        physicalPerson.setName("Micaias");
        physicalPerson.setCpf("074.865.003-29");

        BusinessPerson businessPerson = new BusinessPerson();
        businessPerson.setAuthor(russo);
        businessPerson.setName("Escritor generico");
        businessPerson.setCnpj("60.701.190/0001-04");

        Book harryPotter = new Book();
        harryPotter.setName("Harry Potter");
        harryPotter.setReleaseDate(LocalDate.now());
        harryPotter.setAuthors(Collections.singletonList(micaias));
        Book senhorDosAneis = new Book();
        senhorDosAneis.setName("Senhor dos Aneis");
        senhorDosAneis.setReleaseDate(LocalDate.now());
        senhorDosAneis.setAuthors(Collections.singletonList(micaias));

        Genre drama = new Genre();
        drama.setName("Drama");
        Genre ficcao = new Genre();
        ficcao.setName("Ficcao");

        harryPotter.setGenres(Arrays.asList(drama, ficcao));
        senhorDosAneis.setGenres(Collections.singletonList(drama));
        bookRepository.saveAll(Arrays.asList(harryPotter, senhorDosAneis));
        physicalPersonRepository.save(physicalPerson);
        authorRepository.save(russo);
        businessPersonRepository.save(businessPerson);

        List<Person> persons = personRepository.findAll();
        for(Person person : persons) {
            log.info(person.getName());
            if(person instanceof PhysicalPerson) {
                log.info(((PhysicalPerson) person).getCpf());
            } else {
                log.info(((BusinessPerson) person).getCnpj());
            }
        }
    }
}
