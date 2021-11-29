package ru.dmitryskor.moviesnt

import android.app.Application
import android.content.Context
import ru.dmitryskor.moviesnt.di.AppComponent
import ru.dmitryskor.moviesnt.di.DaggerAppComponent

class MainApp: Application() {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
        get() = checkNotNull(_appComponent) {
            TODO("AppComponent isn't init")
        }


    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.create()
    }
}


val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }