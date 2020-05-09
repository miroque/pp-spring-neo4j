package ru.miroque.pp.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import ru.miroque.pp.nodes.Question;

@Repository
public interface RepositoryQuestion extends Neo4jRepository<Question, Long> {

}
