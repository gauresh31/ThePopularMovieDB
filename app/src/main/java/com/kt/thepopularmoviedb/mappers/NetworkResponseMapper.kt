
package com.kt.thepopularmoviedb.mappers

import com.kt.thepopularmoviedb.models.NetworkResponseModel

interface NetworkResponseMapper<in FROM : NetworkResponseModel> {
    fun onLastPage(response: FROM): Boolean
}
