package com.cubidevs.loginexamplekotlin.Login

class LoginPresenter(): ILoginMVP.presenter {


    private lateinit var view: ILoginMVP.view
    private lateinit var model: ILoginMVP.model

    constructor(view: ILoginMVP.view) : this () {
        this.view = view
        model = LoginModel(this)
    }

    override fun loginButtonClicked() {
        var mail = view.getEmail()
        var password = view.getPassword()
        var phone = view.getPhone()

        if (mail.equals(""))
            view.showEmailError()
        else
            if (password.equals(""))
                view.showPasswordError()
            else
                if (phone.equals(""))
                    view.showPhoneError()
                else
                    model.sendData(mail, password, phone)
    }
}