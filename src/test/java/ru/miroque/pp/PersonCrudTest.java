package ru.miroque.pp;

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
import ru.miroque.pp.nodes.Person;
import ru.miroque.pp.repositories.RepositoryPerson;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest
public class PersonCrudTest{
    @Container
    public static final Neo4jContainer neo4jContainer = new Neo4jContainer().withAdminPassword(null);

    @DynamicPropertySource
    static void datasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.neo4j.uri", neo4jContainer::getBoltUrl);
        registry.add("spring.data.neo4j.password", neo4jContainer::getAdminPassword);
    }

    @Autowired
    public RepositoryPerson rPerson;

    @BeforeEach
    void before() {
        Person item = new Person("foo");
        rPerson.save(item);
    }

    @AfterEach
    void after() {
        rPerson.deleteAll();
    }

    @DisplayName("Создание персоны")
    @Test
    void testCreate() {
        Person item = new Person("bar");
        assertNull(item.getId());
        item = rPerson.save(item);
        assertNotNull(item.getId());
    }

    @DisplayName("Редактирование персоны")
    @Test
    void testEdit() {
        Person item = new Person("bar");
        assertNull(item.getId());
        item = rPerson.save(item);
        assertNotNull(item.getId());
        assertEquals("bar", item.getLogin());
        item.setLogin("foo");
        item.setLevel(99);
        item = rPerson.save(item);
        UUID nid = item.getHook();
        Optional<Person> check = rPerson.findById(nid);
        assertEquals(item.getLogin(), check.get().getLogin());
        assertEquals(item.getLevel(),  check.get().getLevel());
    }


    @DisplayName("Удаление персоны")
    @Test
    void testDelete() {
        Person item = new Person("bar");
        assertNull(item.getId());
        item = rPerson.save(item);
        assertNotNull(item.getId());
        rPerson.delete(item);
        Optional<Person> check = rPerson.findByLogin("bar");
        assertFalse(check.isPresent());
    }

    @DisplayName("Найти персону по логину")
    @Test
    void testFind() {
        Optional<Person> item = rPerson.findByLogin("foo");
        assertTrue(item.isPresent());
//        rPerson.findAll().forEach(person -> log.info("{}", person));
    }

}
