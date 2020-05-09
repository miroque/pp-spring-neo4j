package ru.miroque.pp.relations;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import ru.miroque.pp.nodes.Expectation;
import ru.miroque.pp.nodes.Question;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

@RelationshipEntity(type = "ASKED")
public class RAsked {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime at;

/*    @StartNode
    private Expectation expectation;

    @EndNode
    private Question question;*/

}
