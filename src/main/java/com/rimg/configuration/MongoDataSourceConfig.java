package com.rimg.configuration;

import com.google.common.base.Strings;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * Created by alex on 2017/8/6.
 */
@Configuration
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan
@EnableMongoRepositories(basePackages = "com.rimg.repository.mongo")
public class MongoDataSourceConfig extends AbstractMongoConfiguration {
    
    @Value("${spring.data.mongo.uri}")
    private String dburi;
    
    @Value("${spring.data.mongo.database}")
    private String dbname;
    
    @Value("${spring.data.mongo.host}")
    private String dbhost;
    
    @Value("${spring.data.mongo.port}")
    private String dbport;
    
    @Value("${spring.data.mongo.username}")
    private String username;
    
    @Value("${spring.data.mongo.password}")
    private String password;
    
    @Override
    protected String getDatabaseName() {
        return this.dbname;
    }
    
    public MongoDataSourceConfig(){
        if(null == dbport || "".equalsIgnoreCase(dbport.trim())){
            dbport = "27017";
        }
    }
    
    @Override
    @Bean(name = "mongods")
    public Mongo mongo() throws Exception {
        if (!Strings.isNullOrEmpty(dburi)) {
            Mongo mongo = new MongoClient(new MongoClientURI(dburi));
            return mongo;
        } else {
            ServerAddress serverAdress = new ServerAddress(dbhost, Integer.valueOf(dbport));
            MongoCredential credential = MongoCredential.createMongoCRCredential(username, dbname, password.toCharArray());
            //Do not use new Mongo(), is deprecated.
            Mongo mongo = new MongoClient(serverAdress, Arrays.asList(credential));
            return mongo;
        }
    }
}
