package com.rimg.entity.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by alex on 2017/7/1.
 */
@Data
@Document(collection="col_card")
public class Card implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    @Id
    private String id;
    private String img;
    private String text;
    private Long favorite;
    private Long height;
}
