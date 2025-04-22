package com.agenda.trancas.persistence;


import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
        try {
            // Recupera as variáveis de ambiente
            String dbHost = System.getenv("DB_HOST");
            String dbPort = System.getenv("DB_PORT");
            String dbName = System.getenv("DB_NAME");
            String dbUser = System.getenv("DB_USER");
            String dbPassword = System.getenv("DB_PASSWORD");

            if (dbHost == null || dbPort == null || dbName == null || dbUser == null || dbPassword == null) {
                throw new SQLException("As variáveis de ambiente de conexão não estão configuradas corretamente.");
            }

            // Formata a URL de conexão JDBC com base nas variáveis de ambiente
            String jdbcUrl = String.format("jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC",
                    dbHost, dbPort, dbName);

            // Estabelece a conexão com o banco de dados
            return DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

        } catch (SQLException e) {
            throw new SQLException("Erro ao tentar estabelecer conexão com o banco de dados.", e);
        }
    }
}