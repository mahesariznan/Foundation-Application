package com.iznan.featuretwo.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.iznan.featuretwo.databinding.FragmentPageTwoBinding
import com.iznan.featuretwo.presentation.viewmodel.PageTwoViewModel
import com.iznan.foundation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PageTwoFragment : BaseFragment<FragmentPageTwoBinding>() {

    private val viewModel: PageTwoViewModel by viewModels()
    private val args: PageTwoFragmentArgs by navArgs()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPageTwoBinding {
        return FragmentPageTwoBinding.inflate(inflater, container, false)
    }

    override fun initView() = binding?.apply {
        observeNavigation(viewModel)
        tvData.text = "Hello Page 2 with data: ${args.extraData}"
        btnGoToPageThree.setOnClickListener(goToOtherPage())
    }

    private fun goToOtherPage() = View.OnClickListener {
        viewModel.goToOtherPage(
            PageTwoFragmentDirections.actionPageTwoFragmentToPageThreeFragment(
                "extra data from page 2"
            )
        )
    }

}