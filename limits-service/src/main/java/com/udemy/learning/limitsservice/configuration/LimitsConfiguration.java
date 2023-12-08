package com.udemy.learning.limitsservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("limits-service")
@Data
public class LimitsConfiguration {
    private int minimum;
    private int maximum;
}
