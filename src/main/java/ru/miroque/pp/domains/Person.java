/*******************************************************************************
 * Person System - Person Profile module
 * Copyright (C) 2018, 2019 Panov Aleksander (i.miroque@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.miroque.pp.domains;

import java.time.LocalDateTime;
import java.util.Collections;
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
    @GeneratedValue()
    private Long id;
    private String uuid;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
