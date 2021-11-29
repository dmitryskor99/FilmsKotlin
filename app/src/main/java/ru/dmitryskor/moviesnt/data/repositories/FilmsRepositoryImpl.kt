package ru.dmitryskor.moviesnt.data.repositories

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import retrofit2.Response
import ru.dmitryskor.moviesnt.data.api.ApiFilmsRepositorySource
import ru.dmitryskor.moviesnt.data.api.entities.FilmsResponse
import ru.dmitryskor.moviesnt.domain.repositories.FilmsRepository

class FilmsRepositoryImpl(
    private val apiFilmsRepositorySource: ApiFilmsRepositorySource,
    private val externalCoroutineScope: CoroutineScope
): FilmsRepository {
    override suspend fun loadFilms(page: Int): Response<FilmsResponse> {
        val films = externalCoroutineScope.async {
            apiFilmsRepositorySource.loadFilms(page)
        }.await()

        return films
    }
}