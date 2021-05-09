package com.kt.thepopularmoviedb.models.network

import com.kt.thepopularmoviedb.models.Keyword
import com.kt.thepopularmoviedb.models.NetworkResponseModel

data class KeywordListResponse(
    val id: Int,
    val keywords: List<Keyword>
) : NetworkResponseModel
