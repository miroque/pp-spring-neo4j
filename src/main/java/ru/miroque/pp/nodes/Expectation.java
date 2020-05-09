package ru.miroque.pp.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)

@NodeEntity
public class Expectation {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime started;
    private String name;

    @JsonIgnoreProperties("expectation")
    @Relationship(type = "PROOF", direction = Relationship.INCOMING)
    public Knowledge knowledge;

    @JsonIgnoreProperties({"expectation", "answer"})
    @Relationship(type = "ASKED")
    public List<Question> questions;
}
