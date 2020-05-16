package ru.miroque.pp.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import ru.miroque.pp.nodes.Expectation;

@Repository
public interface RepositoryExpectation extends Neo4jRepository<Expectation, Long> {
    @Override
    Iterable<Expectation> findAll();
}
