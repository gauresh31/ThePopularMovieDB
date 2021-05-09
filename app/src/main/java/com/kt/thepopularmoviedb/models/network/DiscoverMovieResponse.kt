package com.kt.thepopularmoviedb.models.network

import com.kt.thepopularmoviedb.models.NetworkResponseModel
import com.kt.thepopularmoviedb.models.entity.Movie

data class DiscoverMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
) : NetworkResponseModel
