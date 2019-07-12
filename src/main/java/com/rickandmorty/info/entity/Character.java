package com.rickandmorty.info.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

@Transactional
@Entity
@Table(name = "characters")
public class Character implements Serializable {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String status;
    @Column
    private String species;
    @Column
    private String type;
    @Column
    private String gender;
    @Column
    private Long origin_id;
    @Column
    private Long location_id;
    private byte[] image;
    @Column
    private String img_url;
    @Column
    private Timestamp created;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "origin_id", insertable = false, updatable = false )
    private Location origin;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", insertable = false, updatable = false )
    private Location location;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "characters_episodes",
            joinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id", referencedColumnName = "id"))
    private Set<Episode> episodes = new HashSet<>();

    public Character(){}

    public Character(Long id, String name, String status, String species, String type, String gender, Long origin_id, Long location_id, byte[] image, Timestamp created) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin_id = origin_id;
        this.location_id = location_id;
        this.image = image;
        this.created = created;
    }

    public Character(Long id, String name, String status, String species, String type, String gender, byte[] image, Timestamp created) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.image = image;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(Long origin_id) {
        this.origin_id = origin_id;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }

    public String getImg_url() {

        return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(this.getImage());
    }

    public void setImg_url(String img_url) {

        this.img_url = img_url;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getOrigin() {
        return location;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) &&
                Objects.equals(name, character.name) &&
                Objects.equals(status, character.status) &&
                Objects.equals(species, character.species) &&
                Objects.equals(type, character.type) &&
                Objects.equals(gender, character.gender) &&
                Objects.equals(origin_id, character.origin_id) &&
                Objects.equals(location_id, character.location_id) &&
                Arrays.equals(image, character.image) &&
                Objects.equals(created, character.created) &&
                Objects.equals(origin, character.origin) &&
                Objects.equals(location, character.location);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, status, species, type, gender, origin_id, location_id, created, origin, location);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", origin=" + origin +
                ", location=" + location +
                ", episodes=" + episodes +
                '}';
    }
}