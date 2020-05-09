package ru.miroque.pp.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import ru.miroque.pp.domains.Knowledge;
import ru.miroque.pp.domains.Person;

@Repository
public interface RepositoryKnowledge extends Neo4jRepository<Knowledge, Long> {

}
