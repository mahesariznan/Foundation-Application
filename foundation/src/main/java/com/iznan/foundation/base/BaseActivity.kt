package com.iznan.foundation.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun shouldShowBottomNavigation(isVisible: Boolean)

}