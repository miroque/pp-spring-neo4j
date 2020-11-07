package ru.miroque.pp.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ru.miroque.pp.nodes.Person;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositoryPerson extends Neo4jRepository<Person, UUID> {
    Optional<Person> findByLogin(String string);


    @Query("MATCH (e:Person)-[r]-(like) " +
            "WHERE e.login = {prop} " +
            "DELETE e,r,like")
    void delete(@Param("prop") String prop);
}
