///*
// * Copyright 2016-2016 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
package com.progressoft.warehouse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
//
///**
// * Spring Security Configuration.
// *
// * @author Marcelo Fernandes
// */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }



    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.csrf().disable();
            http
                    .userDetailsService(userDetailsService())
                    .authorizeRequests()
                    .antMatchers("/javax.faces.resource/**").permitAll()
                    .antMatchers("/vendor/**").permitAll()
                    .antMatchers("/js/**").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/img/**").permitAll()
                    .antMatchers("/pug/**").permitAll()
                    .antMatchers("/register").permitAll()
                    .antMatchers("/push-pulse").permitAll()


                    .antMatchers("/ean").permitAll()

                    .anyRequest().permitAll();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails user1 = new User("persapiens", "123", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
//        UserDetails user2 = new User("nyilmaz", "qwe", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
//        return new InMemoryUserDetailsManager(Arrays.asList(user1, user2));
//    }
}
