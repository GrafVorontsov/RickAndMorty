package com.rickandmorty.info.service;

import com.rickandmorty.info.entity.Episode;
import com.rickandmorty.info.repository.EpisodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EpisodeService {
    @Autowired
    private final EpisodesRepository episodesRepository;

    public EpisodeService(EpisodesRepository episodesRepository){
        this.episodesRepository = episodesRepository;
    }

    public void createEpisode(Episode episode){
        episodesRepository.save(episode);
    }

    public Episode findById(Long episodeId){
        return episodesRepository.findById(episodeId).orElse(null);}

    List<Episode> findAllByName(String name){ return episodesRepository.findAllByName(name); }

    @Transactional
    public void truncateEpisodesTable() {
        episodesRepository.truncateEpisodesTable();
    }
}
