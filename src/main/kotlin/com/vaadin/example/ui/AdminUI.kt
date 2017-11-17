package com.vaadin.example.ui

import com.vaadin.annotations.Title
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Label
import com.vaadin.ui.UI

@SpringUI(path = "admin")
@Title("LoginPage")
class AdminUI : UI(){

	override fun init(p0: VaadinRequest?) {
		content = Label("Hi this is admin ui")
	}
}