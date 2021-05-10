package com.kt.thepopularmoviedb.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.kt.thepopularmoviedb.R
import com.kt.thepopularmoviedb.databinding.ActivityMovieDetailBinding
import com.kt.thepopularmoviedb.di.ViewModelActivity
import com.kt.thepopularmoviedb.extension.applyToolbarMargin
import com.kt.thepopularmoviedb.extension.simpleToolbarWithHome
import com.kt.thepopularmoviedb.models.entity.Movie
import com.kt.thepopularmoviedb.view.adapter.ReviewListAdapter
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : ViewModelActivity() {

    private val viewModel: MovieDetailViewModel by injectViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding<ActivityMovieDetailBinding>(R.layout.activity_movie_detail).run {
            lifecycleOwner = this@MovieDetailActivity
            viewModel =
                this@MovieDetailActivity.viewModel.apply { postMovieId(getMovieFromIntent()!!.id) }
            movie = getMovieFromIntent()
            reviewAdapter = ReviewListAdapter()
        }
        initializeUI()
    }

    private fun initializeUI() {
        applyToolbarMargin(movie_detail_toolbar)
        simpleToolbarWithHome(movie_detail_toolbar, getMovieFromIntent()!!.title)
    }

    private fun getMovieFromIntent() = intent.getParcelableExtra<Movie>(movieId) as Movie

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == android.R.id.home) onBackPressed()
        return false
    }

    companion object {
        private const val movieId = "movie"
        fun startActivityModel(context: Context?, movie: Movie) {
            if (context != null) {
                val intent = Intent(context, MovieDetailActivity::class.java).apply {
                    putExtra(
                        movieId,
                        movie
                    )
                }
                context.startActivity(intent)
            }
        }
    }
}
