package com.lampa.dogiz.manager

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.lampa.dogiz.model.Auth
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesManager @Inject constructor(@ApplicationContext context: Context?) {

    companion object {
        private const val SHARED_PREFERENCES_FILE_NAME = "dogiz_pref"
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refreshToken"
        private const val EXPIRES_IN = "expiresIn"
    }

    private val sharedPreferences: SharedPreferences? =
        context?.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)

    var userAccessToken: String?
        get() = sharedPreferences?.getString(ACCESS_TOKEN, null)
        set(token) {
            sharedPreferences?.edit {
                putString(ACCESS_TOKEN, token)
            }
        }

    var userRefreshToken: String?
        get() = sharedPreferences?.getString(REFRESH_TOKEN, null)
        set(token) {
            sharedPreferences?.edit {
                putString(REFRESH_TOKEN, token)
            }
        }

    var userExpiresIn: Int?
        get() = sharedPreferences?.getInt(EXPIRES_IN, 0)
        set(token) {
            sharedPreferences?.edit {
                    putInt(EXPIRES_IN, token ?: 0)
            }
        }

    fun setAuthData (auth: Auth) {
        userAccessToken = auth.accessToken
        userRefreshToken = auth.refreshToken
        userExpiresIn = auth.expiresIn
    }
}