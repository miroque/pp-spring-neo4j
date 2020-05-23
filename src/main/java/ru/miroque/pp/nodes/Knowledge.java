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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"knowledges","expectation","check"})

@JsonInclude(JsonInclude.Include.NON_NULL)

@NodeEntity
public class Knowledge {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime recalculated;
    private String name;
    private Integer level;

    @JsonIgnoreProperties("knowledges")
    @Relationship(type = "KNOW",direction = Relationship.OUTGOING)
    public List<Knowledge> knowledges;

    @JsonIgnoreProperties("knowledge")
    @Relationship(type = "PROOF")
    public Expectation expectation;

    @JsonIgnoreProperties("knowledge")
    @Relationship(type = "PROOF")
    public Check check;

    public Knowledge addKnowledge(final Knowledge newKnowledge){
        if (knowledges == null){
            knowledges = new ArrayList<>();
        }
        knowledges.add(newKnowledge);
        return newKnowledge;
    }

        /*

           BandEntity addMember(final SoloArtistEntity soloArtist, final Year joinedIn, final Year leftIn) {
        Optional<Member> existingMember = this.member.stream()
            .filter(m -> m.getArtist().equals(soloArtist) && m.getJoinedIn().equals(joinedIn)).findFirst();
        existingMember.ifPresentOrElse(m -> m.setLeftIn(leftIn), () -> {
            this.member.add(new Member(this, soloArtist, joinedIn, leftIn));
        });

        return this;
    }

        * */

    @Override
    public String toString() {
        return "Knowledge [id=" + id + ", recalculated=" + recalculated + ", name=" + name + ", level=" + level + "]";
    }

}
