package com.rickandmorty.info.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Transactional
@Entity
@Table(name = "locations")
public class Location {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String dimension;
    @Column
    private Timestamp created;

    public Location(){}

    public Location(Long id, String name, String type, String dimension, Timestamp created) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dimension = dimension;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dimension='" + dimension + '\'' +
                '}';
    }
}
