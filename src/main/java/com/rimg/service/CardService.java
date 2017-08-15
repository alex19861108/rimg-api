package com.rimg.service;

import com.rimg.entity.mongo.Card;
import com.rimg.repository.mongo.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 2017/7/1.
 */
@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    
    public List<Card> findAll() {
        return cardRepository.findAll();
    }
}
