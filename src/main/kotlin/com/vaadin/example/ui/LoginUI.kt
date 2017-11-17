package com.vaadin.example.ui

import com.vaadin.annotations.Title
import com.vaadin.example.security.ISecurity
import com.vaadin.server.VaadinRequest
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*
import org.springframework.beans.factory.annotation.Autowired

@SpringUI(path = "/login")
@Title("LoginPage")
class LoginUI : UI() {

	lateinit var user: TextField
	lateinit var password: PasswordField
	var loginButton = Button("Login", this::loginButtonClick)

	@Autowired
	private lateinit var iSecurity: ISecurity

	override fun init(request: VaadinRequest?) {
		setSizeFull()

		user = TextField("User:")
		user.setWidth("300px")
		user.isRequiredIndicatorVisible = true

		password = PasswordField("Password:")
		password.setWidth("300px")
		password.isRequiredIndicatorVisible = true
		password.value = ""

		val fields = VerticalLayout(user, password, loginButton)
		fields.caption = "Please login"
		fields.isSpacing = true
		fields.setMargin(MarginInfo(true, true, true, false))
		fields.setSizeUndefined()

		val verticalLayout = VerticalLayout(fields)
		verticalLayout.setSizeFull()
		verticalLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER)

		setFocusedComponent(user)

		content = verticalLayout
	}

	fun loginButtonClick(event: Button.ClickEvent) {
		iSecurity.autoLogin(user.value, password.value)
	}
}