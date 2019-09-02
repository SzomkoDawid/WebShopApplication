package com.example.webshop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String USERS_QUERY = "SELECT u.login, u.password,1 FROM users u WHERE u.login=?";
    private final String ROLES_QUERY = "select u.login, r.role from users u inner join user_role ur on (u.id = ur.user_id) inner join roles r on (ur.role_id=r.role_id) where u.login=?";
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().usersByUsernameQuery(USERS_QUERY)
                .authoritiesByUsernameQuery(ROLES_QUERY).dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
        auth.inMemoryAuthentication().withUser("dawid94").
                password(bCryptPasswordEncoder.encode("password")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //all
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").permitAll()
                .antMatchers("/signup").permitAll();
        //only users
        http.authorizeRequests()
                .antMatchers("/home/**").hasAnyAuthority("USER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().loginPage("/login")
                .failureUrl("/login?error=true").defaultSuccessUrl("/default")
                .usernameParameter("login")
                .passwordParameter("password")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");

    }
}