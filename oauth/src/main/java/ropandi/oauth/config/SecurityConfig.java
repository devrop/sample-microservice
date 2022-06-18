package ropandi.oauth.config;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import ropandi.oauth.service.impl.CredentialsDetailsService;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	  @Autowired
	  private CredentialsDetailsService credentialUserDetails;
	
	  @Autowired
	  private PasswordEncoder passwordEncoder;
	
	 
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(this.credentialUserDetails).passwordEncoder(this.passwordEncoder);

	  }
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	        .authorizeRequests()
	        .antMatchers("/login", "/**/register/**").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().permitAll();
	  }
	@Bean
    public AuthenticationManager authenticationManagerBean()
        throws Exception {
        return super.authenticationManagerBean();
    }
}
