package com.kt.thepopularmoviedb.view.adapter

import android.view.View
import com.kt.thepopularmoviedb.R
import com.kt.thepopularmoviedb.models.Resource
import com.kt.thepopularmoviedb.models.entity.Movie
import com.kt.thepopularmoviedb.viewholder.MovieListViewHolder

class MovieListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Movie>())
    }

    fun addMovieList(resource: Resource<List<Movie>>) {
            sections()[0].addAll(listOf(resource))
            notifyDataSetChanged()
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_poster

    override fun viewHolder(layout: Int, view: View) = MovieListViewHolder(view)
}
