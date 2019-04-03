package com.cubidevs.loginexamplekotlin.Login

import com.cubidevs.loginexamplekotlin.User

class LoginModel: ILoginMVP.model {

    private var presenter: ILoginMVP.presenter
    private var repository: ILoginRepository
    private lateinit var user: User

    constructor(presenter: ILoginMVP.presenter){
        this.presenter = presenter
        repository = LoginRepository(this)
    }

    override fun sendData(mail: String, password: String, phone: String) {
        user = User (mail, phone)
        repository.authentication(user, password)
    }

    override fun userLoginSuccessful() {
        presenter.userLoginSuccessful()
    }

    override fun userNoExist(password: String) {
        repository.createUser(user, password)
    }

    override fun userCreated() {
        repository.createUserRTDataBase(user)
    }




}