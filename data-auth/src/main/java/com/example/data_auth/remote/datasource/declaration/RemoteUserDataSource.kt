package com.example.data_auth.remote.datasource.declaration

import com.example.data_auth.remote.request.SignInRequest
import com.example.data_auth.remote.response.SignInResponse

interface RemoteUserDataSource {
    suspend fun postUserSignIn(
        signInRequest: SignInRequest
    ): SignInResponse
}