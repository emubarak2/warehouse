package com.progressoft.warehouse.config.mysqldb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * configuration class for dolon mysql db connection
 * Created by eyadm@amazon.com
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "WarehouseEntityManagerFactory",
        transactionManagerRef = "WarehouseTransactionManager",
        basePackages = {"com.progressoft.warehouse.repository"})
@PropertySource("application.properties")
public class WarehouseMysqlConfig {

    @Primary
    @Bean(name = "WarehouseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.warehouse")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "WarehouseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSource())
                .packages("com.progressoft.warehouse.entity")
                .persistenceUnit("DealDPU")
                .build();
    }

//    @Value("${spring.datasource.ipro.jdbcUrl}")
//    private String url;
//    @Value("${spring.datasource.ipro.username}")
//    private String userName;
//    @Value("${spring.datasource.ipro.password}")
//    private String password;
//    @Value("${spring.datasource.ipro.driver-class-name:}")
//    private String driverClass;
//
//    @Bean(name = "SouqIproDataSource")
//    public DataSource dataSource() {
//
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(url);
//        hikariConfig.setUsername(userName);
//        hikariConfig.setDriverClassName(driverClass);
//        hikariConfig.setPassword(password);
//
//
//        return new HikariDataSource(hikariConfig);
//    }
//

    @Primary
    @Bean(name = "WarehouseTransactionManager")

    public PlatformTransactionManager transactionManager(
            @Qualifier("WarehouseEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }


}
