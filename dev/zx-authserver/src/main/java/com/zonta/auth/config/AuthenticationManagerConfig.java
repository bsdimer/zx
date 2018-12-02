package com.zonta.auth.config;


import com.zonta.auth.authentication.BasicAuthenticationProvider;
import com.zonta.auth.authentication.MultiAuthenticationManager;
import com.zonta.auth.authentication.MultiAuthenticationUserDetailService;
import com.zonta.auth.service.UserService;
import com.zonta.auth.service.impl.JpaUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class AuthenticationManagerConfig {

    @Bean
    public UserService jpaUserService(){
        return new JpaUserService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new BasicAuthenticationProvider(new JpaUserService());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
        return new MultiAuthenticationManager()
                .addProvider(authenticationProvider);
    }

    @Bean
    public UserDetailsService userDetailsService(AuthenticationManager authenticationManager) {
        return new MultiAuthenticationUserDetailService(authenticationManager);
    }
}
