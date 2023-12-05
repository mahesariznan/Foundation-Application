package com.iznan.navigator

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph

abstract class BaseNavigation {

    abstract val navController: NavController?

    fun navigate(graphId: Int, args: Bundle? = null, destinationId: Int = -1) {
        navController?.apply {
            if (destinationId != -1) {
                val nestedGraph = graph.findNode(graphId) as? NavGraph
                nestedGraph?.setStartDestination(destinationId)
            }
            navigate(graphId, args)
        }
    }

}