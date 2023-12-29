package com.iznan.foundationapplication

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
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
    override fun shouldShowBottomNavigation(isVisible: Boolean) {
        binding?.bottomNavigationView?.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)
        binding?.bottomNavigationView?.setupWithNavController(navController)
        // For handling multi module
        binding?.bottomNavigationView?.setOnItemSelectedListener {
            when (it.itemId) {
                com.iznan.featureone.R.id.nav_graph_feature_one -> {
                    navController.popBackStack()
                    if (navController.currentDestination?.id != com.iznan.featureone.R.id.pageOneFragment) {
                        navController.navigate(com.iznan.navigator.R.id.nav_graph_feature_one)
                    }
                    true
                }

                com.iznan.navigator.R.id.nav_graph_feature_two -> {
                    if (navController.currentDestination?.id != com.iznan.featuretwo.R.id.pageTwoFragment) {
                        navController.navigate(com.iznan.navigator.R.id.nav_graph_feature_two)
                    }
                    true
                }

                else -> false
            }
        }
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