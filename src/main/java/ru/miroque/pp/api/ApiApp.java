package ru.miroque.pp.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miroque.pp.domains.Person;
import ru.miroque.pp_spring_neo4j.PersonRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/app")
public class ApiApp {
    private final PersonRepository repository;

    public ApiApp(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Collection<Person> location() {
        log.info("-> api/app/");
        return (Collection<Person>) repository.findAll();
    }
}
