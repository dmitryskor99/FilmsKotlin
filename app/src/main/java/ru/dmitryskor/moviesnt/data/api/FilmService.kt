package ru.dmitryskor.moviesnt.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.dmitryskor.moviesnt.BuildConfig
import ru.dmitryskor.moviesnt.data.api.entities.FilmsResponse

interface FilmService {
    @GET("all.json")
    suspend fun getFilms(
        @Query("offset") offset: Int = 0,
        @Query("order") order: String = "",
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ) : Response<FilmsResponse>
}