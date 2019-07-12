package com.rickandmorty.info.schedule;
import com.rickandmorty.info.json.JsonExtractor;
import com.rickandmorty.info.service.CharacterService;
import com.rickandmorty.info.service.EpisodeService;
import com.rickandmorty.info.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Component
@EnableScheduling
@Service
public class ScheduledTasks {
    @Autowired
    LocationService locationService;
    @Autowired
    EpisodeService episodeService;
    @Autowired
    CharacterService characterService;

    @Scheduled(cron = "0 0 23 * * MON")
    public void parsingFromSite() {
        System.out.println("CRON");
        JsonExtractor jx = new JsonExtractor();

        jx.truncateTables(locationService, episodeService, characterService);
        try {
            jx.extractEpisodes();
            jx.extractLocations(locationService);
            jx.extractCharacters(characterService);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
