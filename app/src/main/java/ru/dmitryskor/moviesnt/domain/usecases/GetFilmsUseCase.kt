package ru.dmitryskor.moviesnt.domain.usecases

import ru.dmitryskor.moviesnt.domain.repositories.FilmsRepository

class GetFilmsUseCase(private val repository: FilmsRepository) {
    suspend fun loadFilms(page: Int): Any {
        return repository.loadFilms(page)
    }
}