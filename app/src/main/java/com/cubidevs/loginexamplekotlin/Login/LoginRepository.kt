package com.cubidevs.loginexamplekotlin.Login

import android.util.Log
import com.cubidevs.loginexamplekotlin.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LoginRepository : ILoginRepository {

    private var model: ILoginMVP.model
    private var mAuth: FirebaseAuth? = null


    constructor(model: ILoginMVP.model) {
        this.model = model
    }

    override fun authentication(user: User, password: String) {
        mAuth = FirebaseAuth.getInstance();
        mAuth!!.signInWithEmailAndPassword(user.mail, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    model.userLoginSuccessful()
                } else {
                    Log.d("Error", it.exception.toString())
                    if (it.exception.toString().equals("com.google.firebase.auth.FirebaseAuthInvalidUserException: There is no user record corresponding to this identifier. The user may have been deleted.")){
                        model.userNoExist(password) //caso 1
                    }
                }
            }
    }

    override fun createUser(user: User, password: String) {
        mAuth = FirebaseAuth.getInstance();
        mAuth!!.createUserWithEmailAndPassword(user.mail, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    model.userCreated()
                } else {
                    Log.d("Error", it.exception.toString())
                }
            }
    }

    override fun createUserRTDataBase(user: User) {
        mAuth = FirebaseAuth.getInstance()
        val uid = mAuth!!.uid
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")
        ref.setValue(user)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    model.userLoginSuccessful()
                }
            }
    }
}










