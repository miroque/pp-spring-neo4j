package ru.miroque.pp.domains;

import java.time.LocalDateTime;
import java.util.UUID;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.id.UuidStrategy;

@NodeEntity
public class Knowledge {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String id;
    private LocalDateTime recalculated;
    private String name;
    private Integer level;

    public Knowledge() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Knowledge [id=" + id + ", recalculated=" + recalculated + ", name=" + name + ", level=" + level + "]";
    }

}
