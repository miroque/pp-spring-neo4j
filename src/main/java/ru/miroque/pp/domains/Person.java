package ru.miroque.pp.domains;

import java.time.LocalDateTime;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.id.UuidStrategy;

@NodeEntity
public class Person {

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String id;
    private LocalDateTime recalculated;
    private String login;
    private Integer level;

    @SuppressWarnings("unused")
    private Person() {
    };

    public Person(String login) {
        this.login = login;
    }

    @Relationship(type = "KNOW", direction = Relationship.UNDIRECTED)
    public Set<Knowledge> knowledges;

    public String toString() {
        return this.login + "'s knowledges => " + Optional.ofNullable(this.knowledges).orElse(Collections.emptySet())
                .stream().map(Knowledge::getName).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRecalculated() {
        return recalculated;
    }

    public void setRecalculated(LocalDateTime recalculated) {
        this.recalculated = recalculated;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Set<Knowledge> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(Set<Knowledge> knowledges) {
        this.knowledges = knowledges;
    }

}
