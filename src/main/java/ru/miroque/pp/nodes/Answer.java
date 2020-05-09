package ru.miroque.pp.nodes;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

@NodeEntity
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime given;
    private String value;
    private String valid;

    @Relationship(type = "ANSWERED", direction = Relationship.INCOMING)
    public Question answer;
}
