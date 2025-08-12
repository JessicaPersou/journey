package com.persou.journey.employer.datasources.multitenant;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class LiquibaseConfig {

    private static final String[] TENANTS = {"tenant1", "tenant2"};
    private static final String CHANGELOG_MASTER = "db/changelog/db.changelog-master.xml";

    @Bean
    @Order(1)
    public Liquibase publicLiquibase(DataSource dataSource) throws Exception {
        return runLiquibaseMigration(dataSource, "public", CHANGELOG_MASTER, "main");
    }

    @Bean
    @Order(2)
    public Boolean tenantsLiquibase(DataSource dataSource) throws Exception {
        for (String tenant : TENANTS) {
            createSchemaIfNotExists(dataSource, tenant);
            runLiquibaseMigration(dataSource, tenant, CHANGELOG_MASTER, "tenant");
        }
        return true;
    }

    private Liquibase runLiquibaseMigration(DataSource dataSource, String schema, String changelog, String context)
        throws Exception {
        Connection connection = dataSource.getConnection();
        connection.createStatement().execute("SET SCHEMA '" + schema + "'");

        Database database = DatabaseFactory.getInstance()
            .findCorrectDatabaseImplementation(new JdbcConnection(connection));
        database.setDefaultSchemaName(schema);

        Liquibase liquibase = new Liquibase(
            changelog,
            new ClassLoaderResourceAccessor(),
            database);

        liquibase.update(new Contexts(context));
        return liquibase;
    }

    private void createSchemaIfNotExists(DataSource dataSource, String schema) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE SCHEMA IF NOT EXISTS " + schema);
        }
    }
}