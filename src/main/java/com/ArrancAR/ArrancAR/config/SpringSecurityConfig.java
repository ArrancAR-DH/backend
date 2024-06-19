package com.ArrancAR.ArrancAR.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor

public class SpringSecurityConfig {
    private UserDetailsService userDetailsService;

      @Bean
      public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
      }

      @Bean
      public CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.addAllowedOriginPattern("*");
            configuration.setAllowedMethods(List.of("*"));
            configuration.setAllowedHeaders(List.of("*"));
            configuration.setAllowCredentials(true);
            configuration.setMaxAge(3600L);
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
      }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                    .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(HttpMethod.PUT, "/vehicle/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.PUT, "/user/update").hasAnyRole("SUPER_ADMIN");
                    authorize.requestMatchers(HttpMethod.DELETE, "/vehicle/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.DELETE, "/feature/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.DELETE, "/user/**").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER");
                    authorize.requestMatchers(HttpMethod.DELETE, "/brand/delete").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.DELETE, "/model/delete").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.DELETE, "/type/delete").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.DELETE, "/booking/**").permitAll();
                    authorize.requestMatchers(HttpMethod.POST, "/brand").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.POST, "/model").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.POST, "/feature").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.POST, "/vehicle").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER");
                      authorize.requestMatchers(HttpMethod.POST, "/vehicle/**").permitAll(); // Corregir esto, (pero si funciona dejarlo?)

                      authorize.requestMatchers(HttpMethod.POST, "/user/**").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER");
                    authorize.requestMatchers(HttpMethod.POST, "/user/like").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER");
                    authorize.requestMatchers(HttpMethod.GET, "/vehicle/**").permitAll(); // Cambiado a hasAnyRole para incluir ADMIN
                    authorize.requestMatchers(HttpMethod.GET, "/user/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.GET, "/brand/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.GET, "/type/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.GET, "/model/**").hasAnyRole("SUPER_ADMIN", "ADMIN");
                    authorize.requestMatchers(HttpMethod.GET, "/booking/**").permitAll();
                    authorize.requestMatchers(HttpMethod.POST, "/notification/**").permitAll();
                    authorize.requestMatchers(HttpMethod.POST, "/login").permitAll();
                    authorize.requestMatchers(HttpMethod.POST, "/booking").permitAll();
                    authorize.requestMatchers("/auth/**").permitAll();
                    authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
                    authorize.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
