package com.vaadin.example.security

interface ISecurity {

	fun autoLogin(username: String, password: String)
}