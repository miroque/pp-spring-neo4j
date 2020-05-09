package ru.miroque.pp.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@NoArgsConstructor

@NodeEntity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Relationship(type = "ANSWERED")
    public Answer answer;

    @JsonIgnore
    @Relationship(type = "ASKED", direction = Relationship.INCOMING)
    public Check check;

    @JsonIgnore
    @Relationship(type = "ASKED", direction = Relationship.INCOMING)
    public Expectation expectation;

}
