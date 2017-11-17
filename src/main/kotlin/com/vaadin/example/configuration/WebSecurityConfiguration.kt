package com.vaadin.example.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {

	@Autowired
	fun configureGlobal(auth: AuthenticationManagerBuilder) {
		auth.inMemoryAuthentication().withUser("user").password("123").roles("ADMIN")
	}

	override fun configure(http: HttpSecurity) {
		http.authorizeRequests()
			.antMatchers("/THEME", "/VAADIN/**", "/PUSH/**", "/UIDL/**", "/login", "/error/**", "/accessDenied/**", "/vaadinServlet/**").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")

		http.csrf().disable()
		http.exceptionHandling().accessDeniedPage("/access-denied");
	}
}