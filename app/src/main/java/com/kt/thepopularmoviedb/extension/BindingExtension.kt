package com.kt.thepopularmoviedb.extension

import android.view.View
import android.widget.Toast
import com.kt.thepopularmoviedb.models.Resource
import com.kt.thepopularmoviedb.models.Status

inline fun <reified T> View.bindResource(resource: Resource<T>?, onSuccess: (Resource<T>) -> Unit) {
    if (resource != null) {
        when (resource.status) {
            Status.LOADING -> Unit
            Status.SUCCESS -> onSuccess(resource)
            Status.ERROR ->
                Toast.makeText(
                    context,
                    resource.errorTypes?.status_message.toString(), Toast.LENGTH_SHORT
                ).show()
        }
    }
}
