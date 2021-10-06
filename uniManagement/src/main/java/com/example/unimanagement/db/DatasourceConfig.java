package com.example.unimanagement.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourceConfig {

    private String username;
    private String password;
    private String url;
    private String driver;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Bean(name = "dataSource")
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/uni_manage")
                .username("root")
                .password("root")
                .build();

//        HikariDataSource ds = new HikariDataSource();
//        ds.setDataSourceClassName(this.getDriver());
//        ds.setJdbcUrl(this.getUrl());
//        ds.setPassword(this.getPassword());
//        ds.setUsername(this.getUsername());
//        return ds;
    }

//    @Bean(name = "transactionManager")
//    public DataSourceTransactionManager dataSourceTransactionManager(){
//        return new DataSourceTransactionManager(datasource());
//    }
//
//    public JdbcTemplate jdbcTemplate(){
//        return new JdbcTemplate(datasource());
//    }
}