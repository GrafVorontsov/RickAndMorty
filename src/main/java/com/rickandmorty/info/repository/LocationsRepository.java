package com.rickandmorty.info.repository;

import com.rickandmorty.info.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LocationsRepository extends JpaRepository<Location, Long> {
    @Modifying
    @Query(value = "truncate table locations cascade", nativeQuery = true)
    void truncateLocationsTable();
}
