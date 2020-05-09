package ru.miroque.pp.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import ru.miroque.pp.nodes.Person;

@Repository
public interface RepositoryPerson extends Neo4jRepository<Person, Long> {

}