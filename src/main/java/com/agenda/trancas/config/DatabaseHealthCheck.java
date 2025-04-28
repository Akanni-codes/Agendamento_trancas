package com.agenda.trancas.config;  // Ajuste o pacote conforme sua estrutura

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DatabaseHealthCheck implements HealthIndicator {

    private final DataSource dataSource;

    // Injeção automática do DataSource
    public DatabaseHealthCheck(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Health health() {
        try (Connection conn = dataSource.getConnection()) {
            if (conn.isValid(2)) {  // Testa a conexão com timeout de 2 segundos
                return Health.up().build();
            }
            return Health.down().build();
        } catch (Exception e) {
            return Health.down()
                    .withDetail("error", e.getMessage())
                    .build();
        }
    }
}