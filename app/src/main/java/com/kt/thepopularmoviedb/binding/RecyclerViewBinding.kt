package com.kt.thepopularmoviedb.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kt.thepopularmoviedb.extension.bindResource
import com.kt.thepopularmoviedb.extension.visible
import com.kt.thepopularmoviedb.models.Resource
import com.kt.thepopularmoviedb.models.Review
import com.kt.thepopularmoviedb.models.entity.Movie
import com.kt.thepopularmoviedb.view.adapter.BaseAdapter
import com.kt.thepopularmoviedb.view.adapter.MovieListAdapter
import com.kt.thepopularmoviedb.view.adapter.RecyclerViewPaginator
import com.kt.thepopularmoviedb.view.adapter.ReviewListAdapter
import com.kt.thepopularmoviedb.view.ui.main.MainActivityViewModel

@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view: RecyclerView, adapter: BaseAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, resource: Resource<List<Movie>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? MovieListAdapter
        adapter?.addMovieList(it)
    }
}

@BindingAdapter("moviePagination")
fun bindMoviePagination(view: RecyclerView, viewModel: MainActivityViewModel) {
    RecyclerViewPaginator(
        recyclerView = view,
        loadMore = { viewModel.postMoviePage(it) },
        onLast = { false }
    ).run {
        currentPage = 1
    }
}


@BindingAdapter("adapterReviewList")
fun bindAdapterReviewList(view: RecyclerView, resource: Resource<List<Review>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? ReviewListAdapter
        adapter?.addReviewList(it)
        if (it.data != null) {
            view.visible()
            view.setHasFixedSize(true)
        }
    }
}
