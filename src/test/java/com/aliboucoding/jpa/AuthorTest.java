package com.aliboucoding.jpa;

import com.aliboucoding.jpa.mosels.Author;
import com.aliboucoding.jpa.repositories.AuthorRepository;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.*;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class AuthorTest {

    @Autowired
    private AuthorRepository authorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Faker faker;

    @BeforeEach
    public void setUp() {
        authorRepository.deleteAll();
        faker = new Faker();
    }

    @Test
    @Transactional
    public void testCreateAuthor() {
        // Given
        Author author = Author.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .age(faker.number().numberBetween(20, 60))
                .build();

        // When
        authorRepository.save(author);

        // Then
        assertNotNull(author.getId());
        assertEquals(1, authorRepository.count());
    }

    @Test
    @Transactional
    public void testFindByNameQuery() {
        // Given
        Author author1 = Author.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .age(30)
                .build();

        Author author2 = Author.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .age(40)
                .build();

        authorRepository.save(author1);
        authorRepository.save(author2);

        // When
        TypedQuery<Author> query = entityManager.createNamedQuery("Author.findByNameQuery", Author.class);
        query.setParameter("age", 35);
        List<Author> authors = query.getResultList();

        // Then
        assertEquals(1, authors.size());
        assertEquals(40, authors.get(0).getAge());
    }

    @Test
    @Transactional
    public void testUpdateByNameQuery() {
        // Given
        Author author = Author.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .age(35) // Set age to 25 for testing update
                .build();

        authorRepository.save(author);

        // When
        Query query = entityManager.createNamedQuery("Author.updateByNameQuery");
        query.setParameter("age", 35);
        query.setParameter("id", author.getId());
        query.executeUpdate();

        // Then
        Author updatedAuthor = authorRepository.findById(author.getId()).orElse(null);
        assertNotNull(updatedAuthor);
        assertEquals(35, updatedAuthor.getAge()); // Check if age is updated to 35
    }
}