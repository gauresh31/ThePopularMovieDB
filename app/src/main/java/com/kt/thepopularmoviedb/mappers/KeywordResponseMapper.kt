package com.kt.thepopularmoviedb.mappers

import com.kt.thepopularmoviedb.models.network.KeywordListResponse

class KeywordResponseMapper : NetworkResponseMapper<KeywordListResponse> {
    override fun onLastPage(response: KeywordListResponse): Boolean {
        return true
    }
}
