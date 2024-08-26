package authenticated_route.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import authenticated_route.home.filter.JwtRequestFilter;

@Configuration
public class ConfigFilter {
    @Bean
    public JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter();
    }
    
}
