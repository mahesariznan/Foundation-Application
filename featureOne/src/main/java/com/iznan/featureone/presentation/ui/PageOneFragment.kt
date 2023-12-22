package com.iznan.featureone.presentation.ui

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.iznan.featureone.databinding.FragmentPageOneBinding
import com.iznan.featureone.presentation.viewmodel.PageOneViewModel
import com.iznan.foundation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PageOneFragment : BaseFragment<FragmentPageOneBinding>() {

    private val viewModel: PageOneViewModel by viewModels()

    override fun initBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentPageOneBinding {
        return FragmentPageOneBinding.inflate(inflater, container, false)
    }

    override fun initView(): FragmentPageOneBinding? = binding?.apply {
        isBottomNavigationShow = true
        observeNavigation(viewModel)
        btnGotoOtherModule.setOnClickListener(goToOtherModule())
        btnGoToOtherModuleDifferentStart.setOnClickListener(goToOtherModuleDifferentStart())
        btnGetApiData.setOnClickListener(getApiData())
        observeData()
        viewModel.getLastCoinName()
        viewModel.getCoinDatabase()
    }

    private fun goToOtherModule() = OnClickListener {
        viewModel.goToOtherModule()
    }

    private fun goToOtherModuleDifferentStart() = OnClickListener {
        viewModel.goToOtherModuleDifferentStart()
    }

    private fun getApiData() = OnClickListener {
        viewModel.getCoinList()
    }

    private fun observeData() = with(viewModel) {
        // LiveData
        dataRoom.observe(viewLifecycleOwner, Observer {
            binding?.tvDatabaseData?.text = "data database: ${it.toString()}"
        })

        // StateFlow
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                dataApi.collectLatest { binding?.tvApiData?.text = it }
            }
        }
    }

}