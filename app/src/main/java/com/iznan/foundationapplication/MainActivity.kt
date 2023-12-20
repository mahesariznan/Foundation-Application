package com.iznan.foundationapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.iznan.foundationapplication.databinding.ActivityMainBinding
import com.iznan.navigator.NavControllerBinder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navControllerBinder: NavControllerBinder
    lateinit var navController: NavController

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)
        Log.e("IZN", "IZN buildConfig: ${BuildConfig.BASE_NAME}")
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