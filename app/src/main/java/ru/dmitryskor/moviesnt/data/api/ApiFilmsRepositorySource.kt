package ru.dmitryskor.moviesnt.data.api

import retrofit2.Response
import retrofit2.Retrofit
import ru.dmitryskor.moviesnt.data.api.entities.FilmEntity
import ru.dmitryskor.moviesnt.data.api.entities.FilmsResponse
import ru.dmitryskor.moviesnt.data.api.entities.LinkEntity
import ru.dmitryskor.moviesnt.data.api.entities.MultimediaEntity
import ru.dmitryskor.moviesnt.domain.entities.Film
import ru.dmitryskor.moviesnt.domain.entities.Link
import ru.dmitryskor.moviesnt.domain.entities.Multimedia
import ru.dmitryskor.moviesnt.domain.repositories.FilmsRepository

class ApiFilmsRepositorySource(private val retrofit: Retrofit): FilmsRepository {
    override suspend fun loadFilms(page: Int): Response<FilmsResponse> {
        val offset = (page - 1) * 20
        val response = retrofit.create(FilmService::class.java).getFilms(offset)
        return response
    }

    companion object {
        fun FilmEntity.toFilm(): Film {
            return Film(
                displayTitle = displayTitle,
                mpaaRating = mpaaRating,
                criticsPick = criticsPick,
                byline = byline,
                headline = headline,
                summaryShort = summaryShort,
                publicationDate = publicationDate,
                openingDate = openingDate,
                dateUpdated = dateUpdated,
                link = link?.toLink(),
                multimedia = multimedia?.toMultimedia()
            )
        }

        private fun LinkEntity.toLink(): Link {
            return Link(
                type = type,
                url = url,
                suggestedLinkText = suggestedLinkText
            )
        }

        private fun MultimediaEntity.toMultimedia(): Multimedia {
            return Multimedia(
                type = type,
                src = src,
                width = width,
                height = height
            )
        }
    }
}