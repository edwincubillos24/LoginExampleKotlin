package com.cubidevs.loginexamplekotlin.Login

class LoginModel: ILoginMVP.model {

    private lateinit var presenter: ILoginMVP.presenter
    private lateinit var repository: ILoginRepository

    constructor(presenter: ILoginMVP.presenter){
        this.presenter = presenter
        repository = LoginRepository(this)
    }
}