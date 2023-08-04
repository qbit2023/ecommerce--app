package com.eshopee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@Configuration
public class MicrometerConfig {
    @Bean
    public MeterRegistry meterRegistry() {
        return new SimpleMeterRegistry(); // You can use a different MeterRegistry implementation if needed
    }
}



