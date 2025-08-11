//package org.example.order.config;
//
//import io.seata.rm.datasource.DataSourceProxy;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceProxyConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean("dataSource")
//    public DataSource dataSourceProxy(DataSource druidDataSource) {
//        return new DataSourceProxy(druidDataSource);
//    }
//}