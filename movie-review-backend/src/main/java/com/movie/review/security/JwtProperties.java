package com.movie.review.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix="jwt")  // to read from application.properties
public class JwtProperties {
    private String secretKey;
    private Duration tokenDuration;
}
