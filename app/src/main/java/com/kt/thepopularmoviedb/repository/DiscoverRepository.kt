package com.kt.thepopularmoviedb.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.kt.thepopularmoviedb.api.ApiResponse
import com.kt.thepopularmoviedb.api.TheDiscoverService
import com.kt.thepopularmoviedb.mappers.MovieResponseMapper
import com.kt.thepopularmoviedb.models.Resource
import com.kt.thepopularmoviedb.models.entity.Movie
import com.kt.thepopularmoviedb.models.network.DiscoverMovieResponse
import com.kt.thepopularmoviedb.room.MovieDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiscoverRepository @Inject constructor(
    val discoverService: TheDiscoverService,
    val movieDao: MovieDao,
) : Repository {

    init {
        Log.d("DiscoverRepository","Injection DiscoverRepository")
    }

    fun loadMovies(page: Int): LiveData<Resource<List<Movie>>> {
        return object :
            NetworkBoundRepository<List<Movie>, DiscoverMovieResponse, MovieResponseMapper>() {
            override fun saveFetchData(items: DiscoverMovieResponse) {
                for (item in items.results) {
                    item.page = page
                }
                movieDao.insertMovieList(movies = items.results)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Movie>> {
                return movieDao.getMovieList(page_ = page)
            }

            override fun fetchService(): LiveData<ApiResponse<DiscoverMovieResponse>> {
                return discoverService.fetchDiscoverMovie(page = page)
            }

            override fun mapper(): MovieResponseMapper {
                return MovieResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Log.d("DiscoverRepository","onFetchFailed $message")
            }
        }.asLiveData()
    }
}
