package com.persou.journey.employer.datasources.multitenant;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class LiquibaseConfig {

    private static final String[] TENANTS = {"public", "tenant1", "tenant2"};
    private static final String MAIN_CHANGELOG = "db/changelog/db.changelog-master.xml";
    private static final String TENANT_CHANGELOG = "db/changelog/migrations/tenant-changes.xml";

    @Bean
    public Boolean initializeDatabase(DataSource dataSource) throws SQLException, LiquibaseException {
        // 1. Migração do schema public (dados globais)
        runLiquibaseMigration(dataSource, "public", MAIN_CHANGELOG);

        // 2. Migração para cada tenant
        for (String tenant : TENANTS) {
            if (!tenant.equals("public")) {
                createSchemaIfNotExists(dataSource, tenant);
                runLiquibaseMigration(dataSource, tenant, TENANT_CHANGELOG);
            }
        }

        return true;
    }

    private void createSchemaIfNotExists(DataSource dataSource, String schema) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE SCHEMA IF NOT EXISTS " + schema);
        }
    }

    private void runLiquibaseMigration(DataSource dataSource, String schema, String changelog)
        throws LiquibaseException, SQLException {
        try (Connection connection = dataSource.getConnection()) {
            // Configura o schema padrão para esta migração
            connection.createStatement().execute("SET SCHEMA '" + schema + "'");

            Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(connection));
            database.setDefaultSchemaName(schema);
            database.setLiquibaseSchemaName(schema);

            Liquibase liquibase = new Liquibase(
                changelog,
                new ClassLoaderResourceAccessor(),
                database);

            liquibase.update("");
        }
    }
}