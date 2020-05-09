package ru.miroque.pp.domains;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

@NodeEntity
public class Check {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime started;
    private String name;
}
