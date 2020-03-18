package com.example.onlineshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@DependsOn("passwordEncoder")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/profile/**").authenticated()
//                .antMatchers("/cart/**").access("hasAnyRole('CUSTOMER')")
//                .antMatchers("/order/finish/**").access("hasAnyRole('EMPLOYEE', 'MANAGER')")
//                .antMatchers("/order/**").authenticated()
//                .antMatchers("/profiles/**").authenticated()
//                .antMatchers("/seller/product/new").access("hasAnyRole('MANAGER')")
//                .antMatchers("/seller/**/delete").access("hasAnyRole( 'MANAGER')")
//                .antMatchers("/seller/**").access("hasAnyRole('EMPLOYEE', 'MANAGER')")
//                .antMatchers("/").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin(Customizer.withDefaults())
//                .httpBasic();
        http.authorizeRequests()
                .antMatchers(
                        "/login",
                        "/webResources/**",
                        "/app/**").permitAll()
                .antMatchers("/**").authenticated()
                .and().formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/accessDenied");

        http.sessionManagement()
                .maximumSessions(100)
                .expiredUrl("/login.html");
    }

}
