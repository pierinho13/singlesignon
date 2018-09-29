package com.sso.cliente.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * The core part of this configuration is, of course,
	 *  the @EnableOAuth2Sso annotation we’re using to enable Single Sign On.

	Note that we need to extend the WebSecurityConfigurerAdapter
	 – without it, all the paths will be secured – so the users will be redirected
	  to log in when they try to access any page. In our case here, the index 
	  and login pages are the only pages that can be accessed without authentication.
	Finally, we also defined a RequestContextListener bean to handle requests scopes.
	 */
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
          .authorizeRequests()
          .antMatchers("/login**")
          .permitAll()
          .anyRequest()
          .authenticated();
    }
}
