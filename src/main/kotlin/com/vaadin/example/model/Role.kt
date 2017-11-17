package com.vaadin.example.model

import org.springframework.security.core.GrantedAuthority

class Role : GrantedAuthority{

	var id: Long
	var name: String
	var status: Boolean

	constructor(id: Long, name: String, status: Boolean) {
		this.id = id
		this.name = name
		this.status = status
	}


	override fun getAuthority(): String = name

}