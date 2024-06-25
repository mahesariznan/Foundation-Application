package com.iznan.foundationapplication

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.iznan.foundation.base.BaseActivity
import com.iznan.foundationapplication.databinding.ActivityMainBinding
import com.iznan.foundationapplication.section.ChuckerSection
import com.iznan.foundationapplication.section.ChuckerSectionDelegate
import com.iznan.navigator.NavControllerBinder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity(
    private val chuckerSection: ChuckerSection = ChuckerSection()
) : BaseActivity(), ChuckerSectionDelegate by chuckerSection {

    @Inject
    lateinit var navControllerBinder: NavControllerBinder
    lateinit var navController: NavController

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)
        if (BuildConfig.BASE_NAME.contains("development")) {
            requestNotificationPermission()
        }
    }

    override fun onResume() {
        super.onResume()
        navControllerBinder.bind(navController)
    }

    override fun onPause() {
        super.onPause()
        navControllerBinder.unBind()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}