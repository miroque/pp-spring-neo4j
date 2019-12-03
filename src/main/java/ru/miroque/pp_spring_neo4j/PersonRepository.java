package ru.miroque.pp_spring_neo4j;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.miroque.pp.domains.Person;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface PersonRepository extends CrudRepository<Person, UUID> {

    Person findByLogin(String login);
    Optional<Person> findById(String id);
}
