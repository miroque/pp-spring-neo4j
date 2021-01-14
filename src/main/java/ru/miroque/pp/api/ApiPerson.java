package ru.miroque.pp.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miroque.pp.errors.ExceptionNotFound;
import ru.miroque.pp.nodes.Person;
import ru.miroque.pp.repositories.RepositoryPerson;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/person")
public class ApiPerson {

    private final RepositoryPerson rPerson;

    public ApiPerson(RepositoryPerson repository) {
        this.rPerson = repository;
    }

    @ApiOperation(value = "Получить список всех персон", notes = "Вобще-то так себе метод он не нужен")
    @GetMapping("/")
    public Iterable<Person> all() {
        log.info("-> api/person/");
        log.info("<- api/person/");
        return rPerson.findAll();
    }

    @ApiOperation(value = "Создает новую персону")
    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        log.info("-> create /person/");
        Person p = rPerson.save(person);
        log.info("<- create /person/");
        return ResponseEntity.ok(p);
    }

    @GetMapping(value = "/{nid}", produces = "application/json")
    public ResponseEntity<Person> get(@PathVariable UUID nid) throws ExceptionNotFound {
        log.info("-> get /person/nid::{}", nid);
        Optional<Person> p = rPerson.findById(nid);
        if (p.isPresent()){
            log.info("<- get /person/nid::{}", nid);
            return ResponseEntity.ok(p.get());
        } else {
            log.warn("<-> get /person/nid::{}", nid);
            throw new ExceptionNotFound("No such person");
        }

    }

/*    @PutMapping(value = "/{id}/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person> edit(@PathVariable(name = "id") Person person, @RequestBody Person edited) {
        log.info("-> edit /person/::{}", person.getId());
//        rPerson.findById(person);
//        person.setLevel(edited.getLevel());
//        person.setLogin(edited.getLogin());
        edited.setHook(person.getHook());
        Person p = rPerson.save(edited);
        log.info("<- edit /person/::{}", person.getId());
        return ResponseEntity.ok(p);
    }*/

}
