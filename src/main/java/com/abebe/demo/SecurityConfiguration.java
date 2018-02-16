package com.abebe.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private SSUserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUserDetailsService(userRepository);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
                .authorizeRequests()
                .antMatchers("/h2-console/**","/index","/register","/").permitAll()
                .antMatchers("/postp","poste","postw","posts","summary")
                .access("hasAuthority('USER') ")
                .antMatchers("/displayresume","coverletter").access("hasAuthority('ADMIN')or hasAuthority('USER')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll()
                .and()
                .httpBasic();


        http
                .csrf()
                .disable();
        http
                .headers().frameOptions().disable();
       /* http
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();*/


    }
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("password").authorities("USER")
                .and()
                .withUser("davewolf").password("beastmaster").authorities("ADMIN");
        auth
                .userDetailsService(userDetailsServiceBean());
    }*/

}
