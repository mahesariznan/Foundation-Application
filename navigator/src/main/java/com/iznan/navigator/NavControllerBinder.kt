package com.iznan.navigator

import androidx.navigation.NavController

class NavControllerBinder {

    var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unBind() {
        navController = null
    }

}