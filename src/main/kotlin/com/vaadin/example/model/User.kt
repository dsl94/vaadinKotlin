package com.vaadin.example.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class User(var id: Long, var usName: String, var name: String, var email: String, var pwd: String, var dateCreated: Date,
           var userCreated: String, var dateUpdated: Date, var userUpdate: String, var status: Boolean, var dealerId: Long,
           var firstLogin: Boolean, var roles: List<Role>) : UserDetails {

	override fun getAuthorities() = roles

	override fun isEnabled() = true

	override fun getUsername() = usName

	override fun isCredentialsNonExpired() = true

	override fun getPassword() = pwd

	override fun isAccountNonExpired() = true

	override fun isAccountNonLocked() = true


}