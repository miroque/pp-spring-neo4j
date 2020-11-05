package ru.miroque.pp.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.miroque.pp.nodes.Knowledge;
import ru.miroque.pp.nodes.Person;
import ru.miroque.pp.repositories.RepositoryKnowledge;
import ru.miroque.pp.repositories.RepositoryPerson;

@Slf4j
@RestController
@RequestMapping("/api/knowledge")
public class ApiKnowledge {

    private final RepositoryKnowledge rKnowledge;

    public ApiKnowledge(RepositoryKnowledge repository) {
        this.rKnowledge = repository;
    }

    @GetMapping("/")
    public Iterable<Knowledge> all() {
        log.info("-> api/knowledge/");
        log.info("<- api/knowledge/");
        return rKnowledge.findAll();
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Knowledge> create(@RequestBody Knowledge person) {
        log.info("-> create /knowledge/");
        Knowledge p = rKnowledge.save(person);
        log.info("<- create /knowledge/");
        return ResponseEntity.ok(p);
    }

    @PutMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Knowledge> edit(@RequestBody Knowledge person) {
        log.info("-> edit /knowledge/::{}", person.getId());
        Knowledge p = rKnowledge.save(person);
        log.info("<- edit /knowledge/::{}", person.getId());
        return ResponseEntity.ok(p);
    }

}
