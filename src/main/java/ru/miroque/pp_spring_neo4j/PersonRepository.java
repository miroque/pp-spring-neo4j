package ru.miroque.pp_spring_neo4j;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.miroque.pp.domains.Person;

//TIP: https://stackoverflow.com/questions/42224531/spring-data-neo4j-and-invaliddataaccessapiusageexception-for-index-property
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface PersonRepository extends Neo4jRepository<Person, UUID> {

    Person findByLogin(String login);
    Optional<Person> findById(UUID id);
}
