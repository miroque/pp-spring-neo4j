/*
package ru.miroque.pp.relations;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import ru.miroque.pp.nodes.Knowledge;

@Data
@NoArgsConstructor

@RelationshipEntity(type = "KNOW")
public class RKnow {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private Knowledge previous;

    @EndNode
    private Knowledge next;
}
*/
