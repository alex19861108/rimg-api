package com.rimg.repository.mongo;

import com.rimg.entity.mongo.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by alex on 2017/7/1.
 */
public interface CardRepository extends MongoRepository<Card, String> {
    List<Card> findAll();
}
