package ru.miroque.pp.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import ru.miroque.pp.nodes.Answer;

@Repository
public interface RepositoryAnswer extends Neo4jRepository<Answer, Long> {

}
