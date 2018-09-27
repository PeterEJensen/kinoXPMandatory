package com.example.kinoXP.config;
//Created by Peter
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    //@Qualifier("dataSource")
    @Autowired
    DataSource dataSource;
    //Autowired
    private AccessDeniedHandler accessDeniedHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

                http.csrf().disable()
                .authorizeRequests()
                .antMatchers( "/css/**","/resources/**","/", "/home", "/about", "/index/**", "/register", "/confirm", "/truman", "/eet", "/silencelambs", "/clockwork", "/american","/add/**","/h2-console/**", "/image").permitAll()
                .antMatchers("/admin/**", "/delete", "/create", "/calendar", "/post", "/contact").hasAnyRole("ADMIN")
                .antMatchers("/user/**", "/calendar", "/search", "/search/**", "/contact").hasAnyRole("USER")
                .antMatchers("/", "/home", "/about", "/index/**", "/register", "/confirm", "/truman", "/eet", "/silencelambs", "/clockwork", "/american","/add/**","/h2-console/**", "/css/**", "/js/**").permitAll()
                .antMatchers().hasAnyRole("ADMIN")
                .antMatchers().hasAnyRole("USER")
                        .antMatchers("/webjars/**").permitAll()
                        .antMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
                .and().headers().frameOptions().sameOrigin()//allow use of frame to same origin urls
                .and()
                .formLogin()
                .loginPage("/login")
                        .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}123").roles("USER");//noop removes the use for encrypted password **PASSWORDS ARE STORED IN PLAINTEXT**

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/images/**","/js/**");
    }

   /* @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }
*/
}
