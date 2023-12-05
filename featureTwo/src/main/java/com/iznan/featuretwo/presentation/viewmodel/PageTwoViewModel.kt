package com.iznan.featuretwo.presentation.viewmodel

import androidx.navigation.NavDirections
import com.iznan.foundation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PageTwoViewModel @Inject constructor() : BaseViewModel() {

    internal fun goToOtherPage(navDirections: NavDirections) {
        navigate(navDirections)
    }

}