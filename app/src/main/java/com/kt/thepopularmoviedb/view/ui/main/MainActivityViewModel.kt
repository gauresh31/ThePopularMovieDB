package com.kt.thepopularmoviedb.view.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.kt.thepopularmoviedb.models.Resource
import com.kt.thepopularmoviedb.models.entity.Movie
import com.kt.thepopularmoviedb.repository.DiscoverRepository
import com.kt.thepopularmoviedb.utils.AbsentLiveData
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val discoverRepository: DiscoverRepository,
) : ViewModel() {

    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieListLiveData: LiveData<Resource<List<Movie>>>

    init {
        Log.d("MainActivityViewModel", "injection MainActivityViewModel")

        movieListLiveData = moviePageLiveData.switchMap {
            moviePageLiveData.value?.let { discoverRepository.loadMovies(it) }
                ?: AbsentLiveData.create()
        }
    }

    fun getMovieListValues() = movieListLiveData.value

    fun postMoviePage(page: Int) = moviePageLiveData.postValue(page)
}
