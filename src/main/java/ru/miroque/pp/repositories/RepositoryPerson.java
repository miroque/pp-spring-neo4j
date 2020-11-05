package ru.miroque.pp.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import ru.miroque.pp.nodes.Person;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositoryPerson extends Neo4jRepository<Person, UUID> {
    Optional<Person> findByLogin(String string);
}
