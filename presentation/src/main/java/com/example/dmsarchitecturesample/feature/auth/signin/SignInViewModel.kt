package com.example.dmsarchitecturesample.feature.auth.signin

import androidx.lifecycle.viewModelScope
import com.example.database_domain.usecase.LocalUserViewBooleanUseCase
import com.example.dmsarchitecturesample.base.BaseViewModel
import com.example.domain_auth.exception.BadRequestException
import com.example.domain_auth.exception.ConflictException
import com.example.domain_auth.exception.NotFoundException
import com.example.domain_auth.param.LoginParam
import com.example.domain_auth.usecase.RemoteSignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val remoteSignInUseCase: RemoteSignInUseCase,
    private val localUserViewBooleanUseCase: LocalUserViewBooleanUseCase
): BaseViewModel<SignInState, SignInEvent>() {

    private val parameter =
        LoginParam(id = state.value.id, password = state.value.password)

    fun setId(id: String) {
        sendEvent(SignInEvent.InputId(id))
    }

    fun setPassword(password: String) {
        sendEvent(SignInEvent.InputPassword(password))
    }

    override val initialState: SignInState
        get() = SignInState.initial()

    fun signIn() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.Default) {
                    remoteSignInUseCase.execute(parameter)
                }
            }.onSuccess{
                SignInEvent.SignInSuccess
            }.onFailure {
                when(it) {
                    is BadRequestException -> SignInEvent.BadRequestException
                    is NotFoundException -> SignInEvent.NotFoundException
                    is ConflictException -> SignInEvent.ConflictException
                }
            }
        }
    }

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