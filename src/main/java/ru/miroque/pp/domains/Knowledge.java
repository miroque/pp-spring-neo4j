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
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Knowledge {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime recalculated;
    private String name;
    private Integer level;
    
    @Relationship(type = "KNOW", direction = Relationship.UNDIRECTED)
    public Set<Knowledge> knowledges;

    public Knowledge() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getRecalculated() {
        return recalculated;
    }

    public void setRecalculated(LocalDateTime recalculated) {
        this.recalculated = recalculated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    @Override
    public String toString() {
        return "Knowledge [id=" + id + ", recalculated=" + recalculated + ", name=" + name + ", level=" + level + "]";
    }

}
