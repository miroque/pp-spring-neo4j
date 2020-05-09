package ru.miroque.pp.api;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import ru.miroque.pp.domains.Knowledge;
import ru.miroque.pp.domains.Person;
import ru.miroque.pp.repositories.RepositoryKnowledge;
import ru.miroque.pp.repositories.RepositoryPerson;

@Slf4j
@RestController
@RequestMapping("/api/")
public class ApiApp {
    
    private final RepositoryPerson rPerson;
    private final RepositoryKnowledge rKnowledge;

    public ApiApp(RepositoryPerson repository, RepositoryKnowledge rKnowledge) {
        this.rPerson = repository;
        this.rKnowledge = rKnowledge;
    }

    @GetMapping("/person/")
    public Collection<Person> person() {
        log.info("-> api/person/  -- means all persond");
        return (Collection<Person>) rPerson.findAll();
    }

    @GetMapping("/knowledge/")
    public Collection<Knowledge> knowledge() {
        log.info("-> api/person/  -- means all persond");
        return (Collection<Knowledge>) rKnowledge.findAll();
    }
}
