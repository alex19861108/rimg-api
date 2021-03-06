package com.rimg.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by alex on 2017/8/6.
 */
@Configuration
@MapperScan(basePackages = "com.rimg.entity.mysql")
public class MysqlMybatisConfig {
    
    @Autowired
    @Qualifier(value = "mysqlds")
    private DataSource mysqlds;
    
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mysqlds);
        return sessionFactory.getObject();
    }
}
