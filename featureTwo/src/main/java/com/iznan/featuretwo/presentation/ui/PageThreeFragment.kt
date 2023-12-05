package com.iznan.featuretwo.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.iznan.featuretwo.databinding.FragmentPageThreeBinding
import com.iznan.featuretwo.presentation.viewmodel.PageThreeViewModel
import com.iznan.foundation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PageThreeFragment : BaseFragment<FragmentPageThreeBinding>() {

    private val viewModel: PageThreeViewModel by viewModels()
    private val args: PageThreeFragmentArgs by navArgs()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPageThreeBinding {
        return FragmentPageThreeBinding.inflate(inflater, container, false)
    }

    override fun initView(): FragmentPageThreeBinding? = binding?.apply {
        observeNavigation(viewModel)
        tvInfo.text = "Hello Page 3 with data: ${args.extraData}"
    }

}