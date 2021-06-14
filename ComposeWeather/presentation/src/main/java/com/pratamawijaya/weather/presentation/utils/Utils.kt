package com.pratamawijaya.weather.presentation.utils

import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.hasPermission(vararg permissions: String) = permissions.all { permission ->
    ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun FragmentActivity.askPermission(requestCode: Int, vararg permissions: String) {
    ActivityCompat.requestPermissions(this, permissions, requestCode)
}