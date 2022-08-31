package com.example.database.storage

import com.example.database.param.LocalUserViewParam
import com.example.database_domain.entity.UserVisibleEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

interface AuthDataStorage {

    fun setAccessToken(token: String)
    fun fetchAccessToken(): String
    fun clearAccessToken()

    fun setRefreshToken(token: String)
    fun fetchRefreshToken(): String
    fun clearRefreshToken()

    fun setViewBoolean(localUserViewParam: LocalUserViewParam)
    fun fetchViewBoolean(): UserVisibleEntity
}