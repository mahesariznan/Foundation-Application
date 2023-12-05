package com.iznan.navigator.navigation

import android.os.Bundle
import androidx.navigation.NavController
import com.iznan.featureone.navigation.IFeatureOneNavigation
import com.iznan.navigator.BaseNavigation
import com.iznan.navigator.NavControllerBinder
import javax.inject.Inject

class FeatureOneNavigation @Inject constructor(val navBinder: NavControllerBinder) :
    BaseNavigation(), IFeatureOneNavigation {

    override val navController: NavController? get() = navBinder.navController

    override fun navigateToOtherModule(data: String) {
        navigate(graphId = com.iznan.featuretwo.R.id.nav_graph_feature_two,
            args = Bundle().apply {
                putString("extraData", data)
            }, destinationId = com.iznan.featuretwo.R.id.pageTwoFragment
        )
    }

    override fun navigateToOtherModuleDifferentStart(data: String) {
        navigate(graphId = com.iznan.featuretwo.R.id.nav_graph_feature_two,
            args = Bundle().apply {
                putString("extraData", data)
            }, destinationId = com.iznan.featuretwo.R.id.pageThreeFragment
        )
    }


}