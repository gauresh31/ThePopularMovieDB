package com.kt.thepopularmoviedb.di

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * ViewModelFragment is an abstract class for request dependency injection and
 * provides implementations of [ViewModel] and [ViewDataBinding] from an abstract information.
 * Do not modify this class. This is a first-level abstraction class.
 * If you want to add more specifications, make another class which extends [ViewModelFragment].
 */
abstract class ViewModelFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    protected inline fun <reified VM : ViewModel>
            injectActivityVIewModels(): Lazy<VM> = activityViewModels { viewModelFactory }

    protected inline fun <reified T : ViewDataBinding> binding(
        inflater: LayoutInflater,
        @LayoutRes resId: Int,
        container: ViewGroup?
    ): T = DataBindingUtil.inflate(inflater, resId, container, false)
}
