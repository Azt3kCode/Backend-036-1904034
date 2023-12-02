package com.backend.app.zuul.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(jwtTokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/api/security/oauth/**")
			.permitAll()
			.antMatchers(HttpMethod.GET,
					"/api/laptops/list",
					"/api/store/list",
					"/api/us/usuarios")
			.permitAll()
			.antMatchers(HttpMethod.GET,
					"/api/laptops/laptop/{id}",
					"/api/store/laptop/{id}/cantidad/{cantidad}",
					"/api/us/usuarios/{id}")
			.hasAnyRole("ADMIN", "USER")
			.antMatchers(HttpMethod.POST,
					"/api/laptops/laptop",
					"/api/us/usuarios")
			.hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.PUT,
					"/api/laptops/laptop/{id}",
					"/api/us/usuarios/{id}")
			.hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.DELETE,
					"/api/laptops/laptop/{id}",
					"/api/us/usuarios/{id}")
			.hasAnyRole("ADMIN")
			.anyRequest()
			.authenticated();
	}

	@Bean
	public JwtTokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("llave_belica_4x4");
		return tokenConverter;
	}
}
