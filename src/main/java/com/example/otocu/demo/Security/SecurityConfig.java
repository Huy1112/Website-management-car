package com.example.otocu.demo.Security;
//tag::securityConfigOuterClass[]

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation
        .authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web
        .builders.HttpSecurity;
import org.springframework.security.config.annotation.web
        .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
        .configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    private String userAccess[] = new String[]{"/Web/**"};
    private String dataAccess[] = new String[]{"/Web/**"};
    private String adminAccess[] = new String[]{"/doc/**"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers(adminAccess).hasRole("ADMIN").anyRequest().authenticated()
                .antMatchers(userAccess).hasAnyRole("ADMIN","USER").anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/Web/index", true)
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password");
//                .defaultSuccessUrl("/Web/index");
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/login.html");
    }

    @Bean
    public PasswordEncoder encoder() {
//    return new StandardPasswordEncoder("53cr3t");
        return NoOpPasswordEncoder.getInstance();
    }
//    @Bean
//    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
//        return new MySimpleUrlAuthenticationSuccessHandler();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService);
//                .passwordEncoder(encoder());

    }

}