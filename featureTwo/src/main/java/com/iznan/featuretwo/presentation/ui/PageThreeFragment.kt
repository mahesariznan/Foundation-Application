package com.iznan.featuretwo.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iznan.featuretwo.presentation.viewmodel.PageThreeViewModel
import com.iznan.foundation.theme.foundationComposeView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PageThreeFragment : Fragment() {

    private val viewModel: PageThreeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return foundationComposeView {
            ExoPlayerViewRoute(viewModel)
        }
    }
}