package ru.miroque.pp.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miroque.pp.nodes.Expectation;
import ru.miroque.pp.nodes.Knowledge;
import ru.miroque.pp.nodes.Person;
import ru.miroque.pp.repositories.RepositoryExpectation;
import ru.miroque.pp.repositories.RepositoryKnowledge;
import ru.miroque.pp.repositories.RepositoryPerson;

import java.util.Collection;

@Slf4j
@RestController
@RequestMapping("/api/")
public class ApiApp {

    private final RepositoryPerson rPerson;
    private final RepositoryKnowledge rKnowledge;
    private final RepositoryExpectation rExpectation;

    public ApiApp(RepositoryPerson repository, RepositoryKnowledge rKnowledge, RepositoryExpectation rExpectation) {
        this.rPerson = repository;
        this.rKnowledge = rKnowledge;
        this.rExpectation = rExpectation;
    }

    @GetMapping("/person/")
    public Collection<Person> person() {
        log.info("-> api/person/  -- means all persond");
        return (Collection<Person>) rPerson.findAll();
    }

    @GetMapping("/knowledge/")
    public Collection<Knowledge> knowledge() {
        log.info("-> api/knowledge/  -- means all persond");
        return (Collection<Knowledge>) rKnowledge.findAll();
    }

    @GetMapping("/expectation/")
    public Collection<Expectation> expectation() {
        log.info("-> api/expectation/  -- means all persond");
        return (Collection<Expectation>) rExpectation.findAll();
    }
}
