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
package ru.miroque.pp.nodes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.driver.types.Point;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.neo4j.ogm.id.UuidStrategy;
import org.neo4j.ogm.typeconversion.UuidStringConverter;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor

@ApiModel(description = "Персона которая вот про которую мы всё хистори и ведем")
@NodeEntity
public class Person {
    private Long id;
    @ApiModelProperty(value = "Натуральный айди, ууид")
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    @Convert(UuidStringConverter.class)
    private UUID nid;
    @ApiModelProperty(value = "Это время когда произошло перерасчет всего древа знаний")
    private LocalDateTime recalculated;
    @ApiModelProperty(value = "Логин, может быть любым и может повторятся")
    private String login;
    private Integer level;


    public Person(String login) {
        this.login = login;
    }

    @Relationship(type = "KNOW", direction = Relationship.OUTGOING)
    public List<Knowledge> knowledges;

    public Knowledge addKnowledge(final Knowledge newKnowledge) {
        if (knowledges == null) {
            knowledges = new ArrayList<>();
        }
        knowledges.add(newKnowledge);
        return newKnowledge;
    }

    public String toString() {
        return "id::" + this.getId()
                + " nid::" +this.getNid()
                + " recalculated::" +this.getRecalculated()
                + " level::" +this.getLevel()
                + " " + this.login + "'s knowledges => " + Optional.ofNullable(this.knowledges).orElse(Collections.emptyList())
                .stream().map(Knowledge::getName).collect(Collectors.toList());
    }

}
