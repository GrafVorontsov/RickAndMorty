package com.rickandmorty.info.repository;

import com.rickandmorty.info.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharactersRepository extends JpaRepository<Character, Long> {
    List<Character> findAllByName(String name);

    @Query(value = "select count(*) from characters", nativeQuery = true)
    Long countAll();

    List<Character> findByNameContainingIgnoreCase(String name);

    @Modifying
    @Query(value = "truncate table characters cascade", nativeQuery = true)
    void truncateCharactersTable();

}
