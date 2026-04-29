package com.pms.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Transforms Railway's DATABASE_URL format to JDBC format
 */
@Configuration
@Profile("prod")
public class DataSourceConfig {

    static {
        String databaseUrl = System.getenv("DATABASE_URL");
        if (databaseUrl != null && !databaseUrl.isEmpty()) {
            // Convert postgresql://user:password@host:port/dbname to jdbc:postgresql://host:port/dbname
            String jdbcUrl = databaseUrl.replace("postgresql://", "jdbc:postgresql://");
            System.setProperty("spring.datasource.url", jdbcUrl);
        }
    }
}
