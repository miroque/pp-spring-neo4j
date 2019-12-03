package ru.miroque.pp_spring_neo4j;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.miroque.pp.domains.Knowledge;
import ru.miroque.pp.domains.Person;

@RepositoryRestResource(collectionResourceRel = "knowledges", path = "knowledges")
public interface KnowledgeRepository extends CrudRepository<Knowledge, UUID> {

    Knowledge findByName(String name);

    Optional<Knowledge> findById(String id);
}
