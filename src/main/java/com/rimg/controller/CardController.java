package com.rimg.controller;

import com.google.gson.Gson;
import com.rimg.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by alex on 2017/7/1.
 */
@RestController
@RequestMapping(value = "/api/card/")
public class CardController {
    @Autowired
    private CardService cardService;
    private Gson gson = new Gson();
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String cardGet() {
        return gson.toJson(cardService.findAll());
    }
}
