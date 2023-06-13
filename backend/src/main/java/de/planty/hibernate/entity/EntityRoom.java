package de.planty.hibernate.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity
public class EntityRoom extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "guidelineSequence", sequenceName = "guideline_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guidelineSequence")
    private @Valid Integer id;
    private @Valid String name;
    private @Valid String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
