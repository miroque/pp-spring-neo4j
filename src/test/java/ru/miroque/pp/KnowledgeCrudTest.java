package ru.miroque.pp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.miroque.pp.nodes.Knowledge;
import ru.miroque.pp.nodes.Person;
import ru.miroque.pp.repositories.RepositoryKnowledge;
import ru.miroque.pp.repositories.RepositoryPerson;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@Testcontainers
@SpringBootTest
public class KnowledgeCrudTest {
    @Container
    public static final Neo4jContainer neo4jContainer = new Neo4jContainer().withAdminPassword(null);

    @DynamicPropertySource
    static void datasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.neo4j.uri", neo4jContainer::getBoltUrl);
        registry.add("spring.data.neo4j.password", neo4jContainer::getAdminPassword);
    }

    @Autowired
    private RepositoryKnowledge rKnowledge;

    @Autowired
    public RepositoryPerson rPerson;

    public static final String USER_LOGIN = "userlogin";

    @BeforeEach
    void before() {
        Person item = new Person(USER_LOGIN);
        rPerson.save(item);
    }

    @AfterEach
    void after() {
        rPerson.delete(USER_LOGIN);
    }


    @DisplayName("Добавление знания персоне " + USER_LOGIN)
    @Test
    void testCreate() {
        Optional<Person> optPerson = rPerson.findByLogin(USER_LOGIN);
        assertTrue(optPerson.isPresent());

        Knowledge kn1 = new Knowledge();
        kn1.setName("первое знание");
        kn1.setLevel(50);
        kn1.setRecalculated(LocalDateTime.now());

        optPerson.get().addKnowledge(kn1);

        Person check = rPerson.save(optPerson.get());
        assertTrue(check.getKnowledges().contains(kn1));

        rPerson.findAll().forEach(i -> log.info("{}", i));
    }

    @DisplayName("Добавление 2х знаний персоне " + USER_LOGIN)
    @Test
    void testCreateTwo() {
        Optional<Person> optPerson = rPerson.findByLogin(USER_LOGIN);
        assertTrue(optPerson.isPresent());

        Knowledge kn1 = new Knowledge();
        kn1.setName("первое знание");
        kn1.setLevel(50);
        kn1.setRecalculated(LocalDateTime.now());

        optPerson.get().addKnowledge(kn1);

        Person check = rPerson.save(optPerson.get());
        assertTrue(check.getKnowledges().contains(kn1));

        Knowledge kn2 = new Knowledge();
        kn2.setName("Второе знание");
        kn2.setLevel(20);
        kn2.setRecalculated(LocalDateTime.now());

        optPerson.get().addKnowledge(kn2);

        check = rPerson.save(optPerson.get());
        assertTrue(check.getKnowledges().contains(kn2));

        rPerson.findAll().forEach(i -> log.info("{}", i));
        rKnowledge.findAll().forEach(i -> log.info("{}", i));
    }


}
