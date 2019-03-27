package com.cubidevs.loginexamplekotlin.Login

class LoginRepository: ILoginRepository {

    private lateinit var model: ILoginMVP.model

    constructor(model: ILoginMVP.model){
        this.model = model
    }
}