package com.example.database.storage

import android.content.Context
import android.preference.PreferenceManager
import com.example.database.param.LocalUserViewParam
import com.example.database.storage.AuthDataStorageImpl.Key.ACCESS_TOKEN
import com.example.database.storage.AuthDataStorageImpl.Key.REFRESH_TOKEN
import com.example.database_domain.entity.UserVisibleEntity
import javax.inject.Inject

class AuthDataStorageImpl @Inject constructor(
    private val context: Context,
    private val userVisibleEntity: UserVisibleEntity
) : AuthDataStorage {

    override fun setAccessToken(token: String) {
        getSharedPreference().edit().let {
            it.putString(ACCESS_TOKEN, token)
            it.apply()
        }
    }

    override fun fetchAccessToken(): String =
        getSharedPreference().getString(ACCESS_TOKEN, "empty")!!

    override fun clearAccessToken() {
        getSharedPreference().edit().let {
            it.remove(ACCESS_TOKEN)
            it.apply()
        }
    }

    override fun setRefreshToken(token: String) {
        getSharedPreference().edit().let {
            it.putString(REFRESH_TOKEN, "empty")
            it.apply()
        }
    }

    override fun fetchRefreshToken(): String =
        getSharedPreference().getString(REFRESH_TOKEN, "empty")!!

    override fun clearRefreshToken() {
        getSharedPreference().edit().let {
            it.remove(REFRESH_TOKEN)
            it.apply()
        }
    }

    override fun setViewBoolean(localUserViewParam: LocalUserViewParam) {
        getSharedPreference().edit().let {
            it.putBoolean(MEAL.toString(), localUserViewParam.meal)
            it.putBoolean(POINT.toString(), localUserViewParam.point)
            it.putBoolean(NOTICE.toString(), localUserViewParam.notice)
        }
    }

    override fun fetchViewBoolean(): UserVisibleEntity =
        UserVisibleEntity(
            getSharedPreference().getBoolean(MEAL.toString(), userVisibleEntity.meal),
            getSharedPreference().getBoolean(POINT.toString(), userVisibleEntity.point),
            getSharedPreference().getBoolean(NOTICE.toString(), userVisibleEntity.notice),
        )


    private fun getSharedPreference() =
        PreferenceManager.getDefaultSharedPreferences(context)

    private object Key {
        const val ACCESS_TOKEN = "ACCESS_TOKEN"
        const val REFRESH_TOKEN = "REFRESH_TOKEN"
    }

    private companion object View {
        const val MEAL: Boolean = false
        const val POINT: Boolean = false
        const val NOTICE: Boolean = false
    }
}