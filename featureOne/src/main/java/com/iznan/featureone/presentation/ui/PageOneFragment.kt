package com.iznan.featureone.presentation.ui

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.iznan.featureone.databinding.FragmentPageOneBinding
import com.iznan.featureone.presentation.viewmodel.PageOneViewModel
import com.iznan.foundation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PageOneFragment : BaseFragment<FragmentPageOneBinding>() {

    private val viewModel: PageOneViewModel by viewModels()

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPageOneBinding {
        return FragmentPageOneBinding.inflate(inflater, container, false)
    }

    override fun initView(): FragmentPageOneBinding? = binding?.apply {
        observeNavigation(viewModel)
        btnGotoOtherModule.setOnClickListener(goToOtherModule())
        btnGoToOtherModuleDifferentStart.setOnClickListener(goToOtherModuleDifferentStart())
    }

    private fun goToOtherModule() = OnClickListener {
        viewModel.goToOtherModule()
    }

    private fun goToOtherModuleDifferentStart() = OnClickListener {
        viewModel.goToOtherModuleDifferentStart()
    }

}