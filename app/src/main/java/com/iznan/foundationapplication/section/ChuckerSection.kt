package com.iznan.foundationapplication.section

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChuckerSection : ChuckerSectionDelegate {

    override fun AppCompatActivity.requestNotificationPermission() {
        if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_DENIED
            && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
        ) {
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            }.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

}