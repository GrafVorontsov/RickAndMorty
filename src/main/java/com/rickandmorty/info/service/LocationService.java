package com.rickandmorty.info.service;

import com.rickandmorty.info.entity.Location;
import com.rickandmorty.info.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationService {
    @Autowired
    private final LocationsRepository locationsRepository;

    public LocationService(LocationsRepository locationsRepository){
        this.locationsRepository = locationsRepository;
    }

    public void createLocation(Location location){
        locationsRepository.save(location);
    }

    @Transactional
    public void truncateLocationsTable() {
        locationsRepository.truncateLocationsTable();
    }
}
