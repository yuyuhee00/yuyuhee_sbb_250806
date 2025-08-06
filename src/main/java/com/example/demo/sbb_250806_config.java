package com.example.demo;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:database.properties")
public class sbb_250806_config {

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource () {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("maria.jdbc.driver"));
        dataSource.setUrl(env.getProperty("maria.jdbc.url"));
        dataSource.setUsername(env.getProperty("maria.jdbc.user"));
        dataSource.setPassword(env.getProperty("maria.jdbc.pass"));
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
        dataSource.setMaxIdle(0);
        return dataSource;
    }

}
