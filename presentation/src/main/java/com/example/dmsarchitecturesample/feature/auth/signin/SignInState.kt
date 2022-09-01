package com.example.dmsarchitecturesample.feature.auth.signin

import com.example.dmsarchitecturesample.base.MviState

data class SignInState(
    val id: String,
    val password: String
) : MviState {
    companion object {
        fun initial() =
            SignInState(id = "", password = "")
    }
}
