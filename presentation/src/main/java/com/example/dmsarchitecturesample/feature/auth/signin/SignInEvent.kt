package com.example.dmsarchitecturesample.feature.auth.signin

import com.example.dmsarchitecturesample.base.MviEvent


sealed class SignInEvent : MviEvent {
    data class InputId(val id: String) : SignInEvent()
    data class InputPassword(val password: String) : SignInEvent()
    object BadRequestException : SignInEvent()
    object NotFoundException : SignInEvent()
    object ConflictException : SignInEvent()
}
