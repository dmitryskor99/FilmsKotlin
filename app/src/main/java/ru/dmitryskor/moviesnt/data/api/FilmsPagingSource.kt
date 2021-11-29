package ru.dmitryskor.moviesnt.data.api

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import retrofit2.Response
import ru.dmitryskor.moviesnt.data.api.ApiFilmsRepositorySource.Companion.toFilm
import ru.dmitryskor.moviesnt.data.api.entities.FilmsResponse
import ru.dmitryskor.moviesnt.domain.entities.Film
import ru.dmitryskor.moviesnt.domain.usecases.GetFilmsUseCase

class FilmsPagingSource(
    private val repositorySource: ApiFilmsRepositorySource
): PagingSource<Int, Film>() {
    override fun getRefreshKey(state: PagingState<Int, Film>): Int? {
        val position = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(position) ?: return null

        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Film> {
        val page = params.key ?: 1
        val response = GetFilmsUseCase(repositorySource).loadFilms(page) as Response<FilmsResponse>

        return if (response.isSuccessful) {
            val films = checkNotNull(response.body()?.results?.map { filmEntity -> filmEntity.toFilm() })
            val prevKey = if (page == 1) null else page - 1
            val nextKey = if (films.size < 20) null else page + 1
            LoadResult.Page(films, prevKey, nextKey)
        } else {
            LoadResult.Error(HttpException(response))
        }
    }
}