package com.rickandmorty.info.service;

import com.rickandmorty.info.entity.Character;
import com.rickandmorty.info.repository.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class CharacterService {
    @Autowired
    private final CharactersRepository charactersRepository;

    public CharacterService(CharactersRepository charactersRepository){
        this.charactersRepository = charactersRepository;
    }

    public void createCharacter(Character character){
        charactersRepository.save(character);
    }

    public void deleteCharacter(Character character){
        charactersRepository.delete(character);
    }
    
    public List<Character> findAll(){
        return charactersRepository.findAll();
    }

    public Character findById(Long characterId){
        return charactersRepository.findById(characterId).orElse(null);
    }

    public List<Character> findAllByName(String name){
        return charactersRepository.findAllByName(name);
    }

    public Character findRandomCharacters() {
            long count = charactersRepository.countAll();

            Random random = new Random();
            int number = random.nextInt((int)count);

        return charactersRepository.getOne((long)number);
    }

    public List<Character> findByNameContainingIgnoreCase(String name){
        return charactersRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    public void truncateCharactersTable() {
        charactersRepository.truncateCharactersTable();
    }
}
