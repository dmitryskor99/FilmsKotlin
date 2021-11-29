package ru.dmitryskor.moviesnt.presentation.fragments.filmsfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import ru.dmitryskor.moviesnt.data.api.ApiFilmsRepositorySource
import ru.dmitryskor.moviesnt.data.api.FilmsPagingSource

class FilmsViewModel(apiFilmsRepositorySource: ApiFilmsRepositorySource) : ViewModel() {
    private val source = FilmsPagingSource(apiFilmsRepositorySource)

    private val config = PagingConfig(
        pageSize = 20,
        prefetchDistance = 20,
        enablePlaceholders = true,
        initialLoadSize = 40,
        maxSize = 1000
    )

    val films = Pager(config) {
        source
    }.flow.cachedIn(viewModelScope).stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty() )
}