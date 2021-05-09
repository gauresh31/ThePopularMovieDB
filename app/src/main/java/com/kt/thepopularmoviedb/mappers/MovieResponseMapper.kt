package com.kt.thepopularmoviedb.mappers

import android.util.Log
import com.kt.thepopularmoviedb.models.network.DiscoverMovieResponse

class MovieResponseMapper : NetworkResponseMapper<DiscoverMovieResponse> {
    override fun onLastPage(response: DiscoverMovieResponse): Boolean {
        Log.d("MovieResponseMapper",
            "loadPage : ${response.page}/${response.total_pages}")
        return response.page > response.total_pages
    }
}
