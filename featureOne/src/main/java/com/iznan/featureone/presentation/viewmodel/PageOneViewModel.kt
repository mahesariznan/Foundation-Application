package com.iznan.featureone.presentation.viewmodel

import com.iznan.featureone.navigation.IFeatureOneNavigation
import com.iznan.foundation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PageOneViewModel @Inject constructor(
    private val nav: IFeatureOneNavigation
) : BaseViewModel() {

    internal fun goToOtherModule() {
        nav.navigateToOtherModule("extra data from page 1")
    }

    internal fun goToOtherModuleDifferentStart() {
        nav.navigateToOtherModuleDifferentStart("extra data from page 1")
    }

}