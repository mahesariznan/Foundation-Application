package com.iznan.navigator.navigation

import androidx.navigation.NavController
import com.iznan.carousell.navigation.IFeatureOneNavigation
import com.iznan.navigator.BaseNavigation
import com.iznan.navigator.NavControllerBinder
import javax.inject.Inject

class FeatureOneNavigation @Inject constructor(val navBinder: NavControllerBinder) :
    BaseNavigation(), IFeatureOneNavigation {

    override val navController: NavController? get() = navBinder.navController

    override fun navigateToOtherModule(data: String) {}


}