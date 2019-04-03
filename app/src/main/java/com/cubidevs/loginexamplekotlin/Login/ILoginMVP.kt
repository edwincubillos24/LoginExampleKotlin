package com.cubidevs.loginexamplekotlin.Login

interface ILoginMVP {

    interface view {
        fun getEmail(): String
        fun getPassword(): String
        fun getPhone(): String
        fun showEmailError()
        fun showPhoneError()
        fun showPasswordError()
        fun showWelcomeMessage()
        fun navigateToMainActivity()
    }

    interface presenter {
        fun loginButtonClicked()
        fun userLoginSuccessful()
    }

    interface model {
        fun sendData(mail: String, password: String, phone: String)
        fun userLoginSuccessful()
        fun userNoExist(password: String)
        fun userCreated()

    }
}
