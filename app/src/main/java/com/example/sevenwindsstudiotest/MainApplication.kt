package com.example.sevenwindsstudiotest

import android.app.Application
import android.content.Context
import com.example.sevenwindsstudiotest.di.AppComponent
import com.example.sevenwindsstudiotest.core.util.constants.Constants
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    private var _appComponent: AppComponent? = null

    val appComponent: AppComponent
        get() = checkNotNull(_appComponent)

    val Context.appComponent: AppComponent
        get() = when (this) {
            is MainApplication -> appComponent
            else -> (applicationContext as MainApplication).appComponent
        }

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(Constants.API_KEY)
    }
}