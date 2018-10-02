package com.codecool.kinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.codecool.kinder.repository")
@PropertySource("application.properties")
@EnableTransactionManagement
public class H2JpaConfig {

    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("org.h2.Driver"));
        dataSource.setUrl(env.getProperty("jdbc:h2:mem:db"));
        dataSource.setUsername(env.getProperty("kinder"));
        dataSource.setPassword(env.getProperty("kinder_admin"));

        return dataSource;
    }

}