package com.kt.thepopularmoviedb.view.adapter

import android.view.View
import com.kt.thepopularmoviedb.R
import com.kt.thepopularmoviedb.models.Resource
import com.kt.thepopularmoviedb.models.Review
import com.kt.thepopularmoviedb.viewholder.ReviewListViewHolder

class ReviewListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Review>())
    }

    fun addReviewList(resource: Resource<List<Review>>) {
        if(resource.data != null) {
            sections()[0].addAll(listOf(resource))
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_review

    override fun viewHolder(layout: Int, view: View) = ReviewListViewHolder(view)
}
