package com.orileo.edairy.authservice.config;

import javax.servlet.http.HttpServletResponse;

/**
 * @author H Kapil Kumar
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.orileo.edairy.authservice.service.CustomeUserDetailService;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomeUserDetailService customUserDetailService;

	@Override
	public void configure(HttpSecurity http) throws Exception{

		http
            .requestMatchers()
            .antMatchers("/oauth/token", "/open/**", "/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**")
            .and()
            .authorizeRequests().anyRequest().authenticated();
        //http.csrf().disable();
  
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {

		//authBuilder.inMemoryAuthentication()
		//.withUser("kapil").password("1234").roles("USER")
		//.and()
		// .withUser("admin").password("admin").roles("ADMIN");
		authBuilder.parentAuthenticationManager(authenticationManager)
		.userDetailsService(customUserDetailService);
	}


}