package ru.miroque.pp_spring_neo4j;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.miroque.pp.domains.Person;

//TIP: https://stackoverflow.com/questions/42224531/spring-data-neo4j-and-invaliddataaccessapiusageexception-for-index-property
//TIP: https://medium.com/neo4j/neo4j-ogm-and-spring-data-neo4j-a55a866df68c
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface PersonRepository extends CrudRepository<Person, String> {

    Person findByLogin(String login);
}
