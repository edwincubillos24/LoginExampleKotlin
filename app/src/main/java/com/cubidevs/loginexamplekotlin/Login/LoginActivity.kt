package com.cubidevs.loginexamplekotlin.Login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cubidevs.loginexamplekotlin.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), ILoginMVP.view {

    private lateinit var presenter: ILoginMVP.presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        bLogin.setOnClickListener {
            presenter.loginButtonClicked()
        }
    }

    override fun getEmail(): String {
        return eEmail.text.toString()
    }

    override fun getPassword(): String = ePassword.text.toString()
    override fun getPhone(): String = ePhone.text.toString()

    override fun showEmailError() {
        eEmail.error = "Debe digitar un correo electronico"
    }

    override fun showPhoneError() {
        ePhone.error = "Debe digitar un numero de telefono"
    }
    override fun showPasswordError() {
        ePassword.error = "Debe digitar una contrasena"
    }
}


