package com.encryptpref.example

import android.app.Application
import com.encryptpreference.EncPref

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        EncPref.Builder()
            .setContext(this)
            .serPrefName(this.packageName)
            .serUseDefaultPref(true)
            .setDebuggable(false)
            .build()
    }
}