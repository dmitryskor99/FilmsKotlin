package ru.dmitryskor.moviesnt.di

import dagger.Component
import ru.dmitryskor.moviesnt.data.api.ApiFilmsRepositorySource
import ru.dmitryskor.moviesnt.di.modules.AppModule
import ru.dmitryskor.moviesnt.di.modules.FilmsModule
import ru.dmitryskor.moviesnt.di.modules.NetworkModule

@Component(modules = [
    NetworkModule::class,
    FilmsModule::class,
    AppModule::class]
)
interface AppComponent {
    fun getApi(): ApiFilmsRepositorySource
}