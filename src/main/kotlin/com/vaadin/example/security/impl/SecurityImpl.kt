package com.vaadin.example.security.impl

import com.vaadin.example.security.ISecurity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class SecurityImpl : ISecurity{

	@Autowired
	private lateinit var authManager: AuthenticationManager

	@Autowired
	@Qualifier(value = "CustomUserDetailService")
	private lateinit var userDetailsService: UserDetailsService

	override fun autoLogin(username: String, password: String) {
		var isLogin = false;
		val userDetails = userDetailsService.loadUserByUsername(username)

		val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, password, userDetails.authorities)

		authManager.authenticate(usernamePasswordAuthenticationToken)

		if (usernamePasswordAuthenticationToken.isAuthenticated) {
			SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
			isLogin = true
		}
	}
}