package com.example.sevenwindsstudiotest.core

import android.content.SharedPreferences
import com.example.sevenwindsstudiotest.core.util.constants.PreferencesKey
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val savedToken = sharedPreferences.getString(PreferencesKey.ACCESS_TOKEN, "")
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $savedToken")
            .build()
        return chain.proceed(request)
    }
}
