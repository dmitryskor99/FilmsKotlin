package ru.dmitryskor.moviesnt.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import ru.dmitryskor.moviesnt.data.api.ApiFilmsRepositorySource
import ru.dmitryskor.moviesnt.data.repositories.FilmsRepositoryImpl

@Module
class FilmsModule {
    @Provides
    fun providesFilmsRepositoryImpl(
        apiFilmsRepositorySource: ApiFilmsRepositorySource,
        externalCoroutineScope: CoroutineScope
    ): FilmsRepositoryImpl {
        return FilmsRepositoryImpl(
            apiFilmsRepositorySource,
            externalCoroutineScope
        )
    }
}