package com.vaadin.example.ui

import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Label
import com.vaadin.ui.UI

@SpringUI
class MainUI : UI() {

	override fun init(p0: VaadinRequest?) {
		content = Label("Hello I am the root UI")
	}
}