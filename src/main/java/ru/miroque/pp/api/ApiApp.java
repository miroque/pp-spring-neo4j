package ru.miroque.pp.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miroque.pp.nodes.Answer;
import ru.miroque.pp.nodes.Expectation;
import ru.miroque.pp.nodes.Knowledge;
import ru.miroque.pp.nodes.Person;
import ru.miroque.pp.nodes.Question;
import ru.miroque.pp.repositories.RepositoryAnswer;
import ru.miroque.pp.repositories.RepositoryExpectation;
import ru.miroque.pp.repositories.RepositoryKnowledge;
import ru.miroque.pp.repositories.RepositoryPerson;
import ru.miroque.pp.repositories.RepositoryQuestion;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/")
public class ApiApp {

    private final RepositoryPerson rPerson;
    private final RepositoryKnowledge rKnowledge;
    private final RepositoryExpectation rExpectation;
    private final RepositoryAnswer rAnswer;
    private final RepositoryQuestion rQuestion;

    public ApiApp(RepositoryPerson repository, RepositoryKnowledge rKnowledge, RepositoryExpectation rExpectation, RepositoryAnswer rAnswer, RepositoryQuestion rQuestion) {
        this.rPerson = repository;
        this.rKnowledge = rKnowledge;
        this.rExpectation = rExpectation;
        this.rAnswer = rAnswer;
        this.rQuestion = rQuestion;
    }
    /*
     * @GetMapping("/person/") public Collection<Person> person() {
     * log.info("-> api/person/  -- means all persond"); return (Collection<Person>)
     * rPerson.findAll(); }
     *
     * @PostMapping(value = "/person/", consumes = "application/json", produces =
     * "application/json") public ResponseEntity<Person> person(@RequestBody Person
     * person) { log.info("-> new /person/"); Person p = rPerson.save(person);
     * log.info("<- new /person/"); return ResponseEntity.ok(p); }
     */

    @PostMapping(value = "/person/{id}/knowledge", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person> addKnowledgeToPerson(@PathVariable UUID id, @RequestBody Knowledge item) {
        log.info("-> new /person/");
        Optional<Person> p = rPerson.findById(id);
        p.ifPresent(person -> {
            person.addKnowledge(item);
            rPerson.save(p.get());
        });
        log.info("<- new /person/");
        return ResponseEntity.ok(p.get());
    }

    /*
     * @GetMapping("/knowledge/") public Collection<Knowledge> knowledge() {
     * log.info("-> api/knowledge/  -- means all persond"); return
     * (Collection<Knowledge>) rKnowledge.findAll(); }
     */


    @PostMapping(value = "/knowledge/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Knowledge> newKnowledge(@PathVariable Long id, @RequestBody Knowledge item) {
        //TODO:
        // Here we need get from FRONTEND some info about to WHOM PERSON
        // need add new Knowledge and if this adding to node or to person
        // i need create RELATION to this something
        log.info("-> new /knowledge/");
//        Knowledge ent = rKnowledge.save(item);
        Optional<Knowledge> cur = rKnowledge.findById(id);
//        cur.ifPresent(item::addKnowledge);
        cur.ifPresent(c -> c.addKnowledge(item));
        rKnowledge.save(cur.get());
//        log.info("<- new /knowledge/   way-01: save new item"); - NO success
        log.info("<- new /knowledge/   way-02: save current item");
        return ResponseEntity.ok(item);
    }

    @GetMapping("/expectation/")
    public Collection<Expectation> expectation() {
        log.info("-> api/expectation/  -- means all persond");
        return (Collection<Expectation>) rExpectation.findAll();
    }

    @GetMapping("/answer/")
    public Collection<Answer> answer() {
        log.info("-> api/answer/  -- means all persond");
        return (Collection<Answer>) rAnswer.findAll();
    }

    @GetMapping("/question/")
    public Collection<Question> question() {
        log.info("-> api/question/  -- means all persond");
        return (Collection<Question>) rQuestion.findAll();
    }
}
