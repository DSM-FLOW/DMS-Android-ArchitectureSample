package com.example.dmsarchitecturesample.feature.auth.signin

import com.example.database_domain.usecase.LocalUserViewBooleanUseCase
import com.example.dmsarchitecturesample.base.BaseViewModel
import com.example.domain_auth.param.LoginParam
import com.example.domain_auth.usecase.RemoteSignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val remoteSignInUseCase: RemoteSignInUseCase,
    private val localUserViewBooleanUseCase: LocalUserViewBooleanUseCase
): BaseViewModel<SignInState, SignInEvent>() {

    val parameter =
        LoginParam(id = state.value.id, password = state.value.password)

    fun setId(id: String) {
        sendEvent(SignInEvent.InputId(id))
    }

    fun setPassword(password: String) {
        sendEvent(SignInEvent.InputPassword(password))
    }

    override val initialState: SignInState
        get() = SignInState.initial()

    override fun reduceEvent(oldState: SignInState, event: SignInEvent) {
        when(event) {
            is SignInEvent.InputId -> {
                setState(oldState.copy(id = event.id))
            }
            is SignInEvent.InputPassword -> {
                setState(oldState.copy(password = event.password))
            }
            else -> {}
        }
    }
}