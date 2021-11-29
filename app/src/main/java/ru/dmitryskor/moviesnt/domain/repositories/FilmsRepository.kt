package ru.dmitryskor.moviesnt.domain.repositories


interface FilmsRepository {
    suspend fun loadFilms(page: Int): Any
}