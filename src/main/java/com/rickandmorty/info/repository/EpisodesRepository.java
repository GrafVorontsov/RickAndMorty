package com.rickandmorty.info.repository;

import com.rickandmorty.info.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodesRepository extends JpaRepository<Episode, Long> {
    List<Episode> findAllByName(String name);

    @Modifying
    @Query(value = "truncate table episodes cascade", nativeQuery = true)
    void truncateEpisodesTable();
}
