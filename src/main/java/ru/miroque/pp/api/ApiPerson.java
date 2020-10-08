package ru.miroque.pp.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miroque.pp.nodes.Person;
import ru.miroque.pp.repositories.RepositoryPerson;

@Slf4j
@RestController
@RequestMapping("/api/person")
public class ApiPerson {

    private final RepositoryPerson rPerson;

    public ApiPerson(RepositoryPerson repository) {
        this.rPerson = repository;
    }

    @GetMapping("/")
    public Iterable<Person> all() {
        log.info("-> api/person/");
        log.info("<- api/person/");
        return rPerson.findAll();
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        log.info("-> create /person/");
        Person p = rPerson.save(person);
        log.info("<- create /person/");
        return ResponseEntity.ok(p);
    }

    @PutMapping(value = "/{id}/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person> edit(@PathVariable(name = "id") Person person, @RequestBody Person edited) {
        log.info("-> edit /person/::{}", person.getId());
//        rPerson.findById(person);
//        person.setLevel(edited.getLevel());
//        person.setLogin(edited.getLogin());
        edited.setHook(person.getHook());
        Person p = rPerson.save(edited);
        log.info("<- edit /person/::{}", person.getId());
        return ResponseEntity.ok(p);
    }

}
