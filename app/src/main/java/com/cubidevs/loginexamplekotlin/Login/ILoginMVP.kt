package com.cubidevs.loginexamplekotlin.Login

interface ILoginMVP {

    interface view{
        fun getEmail(): String
        fun getPassword(): String
        fun getPhone(): String
        fun showEmailError()
        fun showPhoneError()
        fun showPasswordError()
    }

    interface presenter{
        fun loginButtonClicked()
    }

    interface model{

    }
}
