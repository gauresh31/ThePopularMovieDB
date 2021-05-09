package com.kt.thepopularmoviedb.models.network

import com.kt.thepopularmoviedb.models.NetworkResponseModel
import com.kt.thepopularmoviedb.models.Review

class ReviewListResponse(
    val id: Int,
    val page: Int,
    val results: List<Review>,
    val total_pages: Int,
    val total_results: Int
) : NetworkResponseModel
