package com.cubidevs.loginexamplekotlin.Login

import com.cubidevs.loginexamplekotlin.User

interface ILoginRepository {
    fun authentication(user: User, password: String)
    fun createUser(user: User, password: String)
    fun createUserRTDataBase(user: User)
}