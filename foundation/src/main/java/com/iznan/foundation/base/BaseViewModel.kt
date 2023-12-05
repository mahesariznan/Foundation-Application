package com.iznan.foundation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.iznan.foundation.util.Event

abstract class BaseViewModel: ViewModel() {

    private val _navigation = MutableLiveData<Event<NavDirections>>()
    val navigation: LiveData<Event<NavDirections>> = _navigation

    protected fun navigate(navDirections: NavDirections) {
        _navigation.postValue(Event(navDirections))
    }
}