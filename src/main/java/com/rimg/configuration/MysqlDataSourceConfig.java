package com.rimg.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by alex on 2017/8/6.
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class MysqlDataSourceConfig {
    @Value("${spring.data.mysql.driver-class-name}")
    private String driver;
    
    @Value("${spring.data.mysql.url}")
    private String url;
    
    @Value("${spring.data.mysql.username}")
    private String username;
    
    @Value("${spring.data.mysql.password}")
    private String password;
    
    @Bean(name="mysqlds")
    public DataSource mysql()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
