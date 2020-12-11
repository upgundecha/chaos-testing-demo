package com.example.config;

import de.codecentric.spring.boot.chaos.monkey.configuration.ChaosMonkeySettings;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    private final ChaosMonkeySettings chaosMonkeySettings;

    public MetricsConfig(ChaosMonkeySettings chaosMonkeySettings) {
        this.chaosMonkeySettings = chaosMonkeySettings;
    }

    @Bean
    Gauge chaosMonkeyStatusGauge(MeterRegistry registry) {
        Number chaosMonkeyStatus = 0;
        if (chaosMonkeySettings.getChaosMonkeyProperties().isEnabled()) {
            chaosMonkeyStatus = 1;
        }

        return Gauge
                .builder("chaos.monkey.status", chaosMonkeyStatus, this::convert)
                .register(registry);
    }

    private double convert(Number f) {
        Number chaosMonkeyStatus = 0;
        if (chaosMonkeySettings.getChaosMonkeyProperties().isEnabled()) {
            chaosMonkeyStatus = 1;
        }
        return chaosMonkeyStatus.doubleValue();
    }
}