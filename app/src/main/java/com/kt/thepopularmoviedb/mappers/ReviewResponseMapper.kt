package com.kt.thepopularmoviedb.mappers

import com.kt.thepopularmoviedb.models.network.ReviewListResponse


class ReviewResponseMapper : NetworkResponseMapper<ReviewListResponse> {
    override fun onLastPage(response: ReviewListResponse): Boolean {
        return true
    }
}
