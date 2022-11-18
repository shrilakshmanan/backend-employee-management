/*
 * package com.example.demo;
 * 
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.web.SecurityFilterChain; import
 * org.springframework.security.web.session.HttpSessionEventPublisher;
 * 
 * 
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * 
 * 
 * @Autowired private DataSource dataSource;
 * 
 * @Autowired public void configAuthentication(AuthenticationManagerBuilder
 * authBuilder) throws Exception { authBuilder.jdbcAuthentication()
 * .dataSource(dataSource) .passwordEncoder(new BCryptPasswordEncoder())
 * .usersByUsernameQuery("select emailid, password, enabled from signin where emailid=?"
 * )
 * .authoritiesByUsernameQuery("select emailid, roles from signin where emailid=?"
 * ) ; }
 * 
 * @Bean public HttpSessionEventPublisher httpSessionEventPublisher() { return
 * new HttpSessionEventPublisher(); }
 * 
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests() .antMatchers("*").hasAnyRole("Admin")
 * .antMatchers("*").hasAnyRole("Employee")
 * .antMatchers("*").hasAnyRole("Manager")
 * 
 * .anyRequest().authenticated() .and()
 * 
 * .formLogin().permitAll() .and() .logout().permitAll() .and()
 * 
 * 
 * ;
 * 
 * }
 * 
 * 
 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 */