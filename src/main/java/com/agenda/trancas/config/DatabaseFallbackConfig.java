package com.agenda.trancas.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
public class DatabaseFallbackConfig {

    @Bean
    @ConditionalOnProperty(name = "spring.datasource.fallback", havingValue = "true")
    public DataSource dataSource() {
        return new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                throw new SQLException("Fallback datasource - conexão intencionalmente bloqueada");
            }

            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                throw new SQLException("Fallback datasource - conexão intencionalmente bloqueada");
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {
                throw new SQLException("Not supported");
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {
                throw new SQLException("Not supported");
            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {
                throw new SQLException("Not supported");
            }

            @Override
            public int getLoginTimeout() throws SQLException {
                throw new SQLException("Not supported");
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                throw new SQLFeatureNotSupportedException("Not supported");
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                throw new SQLException("Not supported");
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                throw new SQLException("Not supported");
            }
        };
    }
}