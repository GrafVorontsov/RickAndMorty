package com.rickandmorty.info.controller;

import com.rickandmorty.info.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private CharacterService characterService;

    private MainController(){}

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Rick and Morty information site";

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/characterList" }, method = RequestMethod.POST)
    public String handlingParametr(@RequestParam("search_name") String searchName, Model model) {

        if(!"".equals(searchName)) {
            model.addAttribute("charList", characterService.findByNameContainingIgnoreCase(searchName));
        } else {
            model.addAttribute("charRand", characterService.findRandomCharacters());
        }

        return "characterList";
    }

}
