package com.kt.thepopularmoviedb.models.network

data class ErrorTypes(
    val status_code: Int,
    val status_message: String,
    val success: Boolean
)
