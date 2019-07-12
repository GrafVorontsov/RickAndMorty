package com.rickandmorty.info.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String air_date;
    @Column
    private String episode;
    @Column
    private Timestamp created;

    /*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "characters_episodes",
            joinColumns = { @JoinColumn(name = "episode_id") },
            inverseJoinColumns = { @JoinColumn(name = "character_id") })
    private Set<com.rickandmorty.info.entity.Character> characterSet = new HashSet<>();
*/
    @ManyToMany(mappedBy = "episodes")
    private Set<Character> characterSet = new HashSet<>();

    public Set<Character> getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(Set<Character> characterSet) {
        this.characterSet = characterSet;
    }

    public Episode(){}

    public Episode(Long id, String name, String air_date, String episode, Timestamp created) {
        this.id = id;
        this.name = name;
        this.air_date = air_date;
        this.episode = episode;
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

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", air_date='" + air_date + '\'' +
                ", episode='" + episode + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
