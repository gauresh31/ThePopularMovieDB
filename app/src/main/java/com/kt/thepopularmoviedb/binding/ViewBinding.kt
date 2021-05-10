package com.kt.thepopularmoviedb.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.chip.ChipGroup
import com.kt.thepopularmoviedb.api.Api
import com.kt.thepopularmoviedb.extension.addPrimaryChip
import com.kt.thepopularmoviedb.extension.bindResource
import com.kt.thepopularmoviedb.extension.requestGlideListener
import com.kt.thepopularmoviedb.extension.visible
import com.kt.thepopularmoviedb.models.Keyword
import com.kt.thepopularmoviedb.models.Resource
import com.kt.thepopularmoviedb.models.entity.Movie

@BindingAdapter("visibilityByResource")
fun bindVisibilityByResource(view: View, resource: Resource<List<Any>>?) {
    view.bindResource(resource) {
        if (resource?.data != null) {
            view.visible()
        }
    }
}

@BindingAdapter("mapKeywordList")
fun bindMapKeywordList(view: ChipGroup, resource: Resource<List<Keyword>>?) {
    view.bindResource(resource) {
        if (it.data != null) {
            view.visible()
            it.data.forEach { keyword -> view.addPrimaryChip(keyword.name) }
        }
    }
}

@BindingAdapter("bindReleaseDate")
fun bindReleaseDate(view: TextView, movie: Movie) {
    view.text = "Release Date : ${movie.release_date}"
}

@BindingAdapter("bindBackDrop")
fun bindBackDrop(view: ImageView, movie: Movie) {
    if (movie.backdrop_path != null) {
        Glide.with(view.context).load(Api.getBackdropPath(movie.backdrop_path))
            .listener(view.requestGlideListener())
            .into(view)
    } else {
        Glide.with(view.context).load(Api.getBackdropPath(movie.poster_path!!))
            .listener(view.requestGlideListener())
            .into(view)
    }
}