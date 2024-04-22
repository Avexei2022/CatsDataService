package ru.gb.group_4546_5984.spring_sem07_task1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/**
 * Включение и настройка Spring Security для веб-приложения
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Цепочка фильтров по настройке параметров безопасности
     * @param http экземпляр HttpSecurity -  настройка веб-безопасности для определенных http-запросов
     * @return цепочка фильтров
     * @throws Exception исключения
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/css/**", "/", "/index", "/img/pet-house.svg").permitAll()
                        .requestMatchers("/user", "/public-data").hasAnyRole("USER")
                        .requestMatchers("/admin", "/private-data").hasAnyRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .exceptionHandling(exception -> exception.accessDeniedPage("/error-page"))
                .formLogin(login -> login
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/"));
        return http.build();
    }

    /**
     * Одностороннее преобразование пароля
     * @return экземпляр DelegatingPasswordEncoder
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * Создание новых пользователей с обеспечением поддержки аутентификации
     * на основе имени пользователя и пароля, которые хранятся в памяти,
     * для тестирования и демострации
     * @return экземпляр класса InMemoryUserDetailsManager
     */
    @Bean
    UserDetailsManager inMemoryUserDetailsManager() {
        var user1 = User.withUsername("user1").password("{noop}user1").roles("USER").build();
        var user2 = User.withUsername("user2").password("{noop}user2").roles("USER").build();
        var user3 = User.withUsername("user3").password("{noop}user3").roles("USER").build();
        var user4 = User.withUsername("user4").password("{noop}user4").roles("USER").build();
        var user5 = User.withUsername("user5").password("{noop}user5").roles("USER").build();
        var admin = User.withUsername("admin").password("{noop}admin").roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(user1, user2, user3, user4, user5, admin );
    }
}
