package com.vaadin.example.services

import com.vaadin.example.model.Role
import com.vaadin.example.model.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*

@Service("CustomUserDetailService")
class CustomUserDetailService : UserDetailsService {

	override fun loadUserByUsername(username: String): UserDetails? {

		var roles = ArrayList<Role>()
		if(username.equals("user")) {
			roles.add(Role(1, "ADMIN", true))
			var user =  User(1L, username, "Name", "email@email.com",
				"123", Date(), "test", Date(), "test",
				true, 1L, true, roles)
			return user;
		}

		return null
	}
}