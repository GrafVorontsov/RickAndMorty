package com.rickandmorty.info.json;

import com.rickandmorty.info.entity.Character;
import org.json.JSONArray;
import org.json.JSONObject;
import com.rickandmorty.info.entity.Episode;
import com.rickandmorty.info.entity.Location;
import com.rickandmorty.info.converter.ConvertImgToInputStream;
import com.rickandmorty.info.converter.ConvertStringToInt;
import com.rickandmorty.info.converter.ConvertTimestamp;
import com.rickandmorty.info.service.CharacterService;
import com.rickandmorty.info.service.EpisodeService;
import com.rickandmorty.info.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

public class JsonExtractor{

    private Map<Long, Episode> map;

    public JsonExtractor() {

    }

    public void truncateTables(LocationService locationService, EpisodeService episodeService, CharacterService characterService){
        episodeService.truncateEpisodesTable();
        locationService.truncateLocationsTable();
        characterService.truncateCharactersTable();
    }

    public void extractEpisodes() throws IOException {
        String stringURL = "https://rickandmortyapi.com/api/episode";
        String next;
        map = new TreeMap<>();

        do {
            new JsonReader();
            JSONObject json = JsonReader.readJsonFromUrl(stringURL);

            JSONArray results = json.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {

                JSONObject object = results.getJSONObject(i);

                Long id = object.getLong("id");
                String name = object.getString("name");
                String air_date = object.getString("air_date");
                String episode_number = object.getString("episode");
                String createdString = object.getString("created");
                Timestamp created = ConvertTimestamp.srtToTimestamp(createdString);

                Episode episode = new Episode(id, name, air_date, episode_number, created);
                map.put(id, episode);
            }

            JSONObject info = json.getJSONObject("info");
            next = info.getString("next");
            stringURL = next;

        } while (!"".equals(next));
    }

    public void extractLocations(LocationService locationService) throws IOException {
        String stringURL = "https://rickandmortyapi.com/api/location";
        String next;

        locationService.createLocation(new Location(
                0L, "unknown", "unknown", "unknown",
                ConvertTimestamp.srtToTimestamp("2018-01-11T17:11:26.574Z")));

        do {
            new JsonReader();
            JSONObject json = JsonReader.readJsonFromUrl(stringURL);

            JSONArray results = json.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {

                JSONObject object = results.getJSONObject(i);

                Long id = object.getLong("id");
                String name = object.getString("name");
                String type = object.getString("type");
                String dimension = object.getString("dimension");
                String createdString = object.getString("created");
                Timestamp created = ConvertTimestamp.srtToTimestamp(createdString);

                Location location = new Location(id, name, type, dimension, created);
                locationService.createLocation(location);
            }

            JSONObject info = json.getJSONObject("info");
            next = info.getString("next");
            stringURL = next;

        } while (!"".equals(next));
    }

    public void extractCharacters(CharacterService characterService) throws IOException {
        String stringURL = "https://rickandmortyapi.com/api/character";
        String next;

        do {
            new JsonReader();
            JSONObject json = JsonReader.readJsonFromUrl(stringURL);

            JSONArray results = json.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {

                JSONObject object = results.getJSONObject(i);

                Long id = object.getLong("id");
                String name = object.getString("name");
                String status = object.getString("status");
                String species = object.getString("species");
                String type = object.getString("type");
                String gender = object.getString("gender");

                String originString = object.getJSONObject("origin").getString("url");
                Long origin_id = 0L;
                if (!"".equals(originString)) {
                    origin_id = ConvertStringToInt.srtToLong(originString);
                }

                String locationString = object.getJSONObject("location").getString("url");
                Long location_id = 0L;
                if (!"".equals(locationString)) {
                    location_id = ConvertStringToInt.srtToLong(locationString);
                }

                String imageURL = object.getString("image");
                byte[] image = ConvertImgToInputStream.imgToIS(imageURL);

                //ArrayList<Long> episodesNumbers = new ArrayList<>();
                Set<Episode> episodes = new LinkedHashSet<>();

                JSONArray arrayEpisodes = object.optJSONArray("episode");

                for (int j = 0; j < arrayEpisodes.length(); j++) {
                    Long _id = ConvertStringToInt.srtToLong(arrayEpisodes.optString(j));
                    for(Map.Entry<Long, Episode> item : map.entrySet()){
                        Long key = item.getKey();
                        if (key.equals(_id)){
                            episodes.add(item.getValue());
                        }
                    }
                }

                String createdString = object.getString("created");
                Timestamp created = ConvertTimestamp.srtToTimestamp(createdString);

                com.rickandmorty.info.entity.Character character = new Character(id, name, status, species, type, gender, origin_id,
                        location_id, image, created);
                character.setEpisodes(episodes);

                characterService.createCharacter(character);
                System.out.println(character);
            }

            JSONObject info = json.getJSONObject("info");
            next = info.getString("next");
            stringURL = next;

        } while (!"".equals(next));
    }


}
