package com.pratamawijaya.presentation.base

import android.Manifest
import android.annotation.SuppressLint
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import pub.devrel.easypermissions.EasyPermissions
import javax.inject.Inject

abstract class LocationActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    @Inject
    lateinit var locationProvider: FusedLocationProviderClient

    @Inject
    lateinit var geocoder: Geocoder

    private val locationRequest: LocationRequest by lazy {
        LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 5 * 1000
        }
    }

    private val locationCallback: LocationCallback by lazy {
        object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                super.onLocationResult(result)
                locationProvider.removeLocationUpdates(locationCallback)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val perms = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        if (!EasyPermissions.hasPermissions(this, *perms)) {
            EasyPermissions.requestPermissions(this, "", 1, *perms)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        Log.d("debug", "permission granted")
        if (requestCode == 1) {
            getLocation()
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        Log.d("debug", "permission denied")
        onLocationRequestCanceled()
    }

    @SuppressLint("MissingPermission")
    protected fun getLocation() {
        locationProvider.lastLocation.addOnSuccessListener { location ->
            location?.let {
                val cityName = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                    .firstOrNull()?.locality

                if (cityName != null) {
                    Log.d("debug", "success get city name : $cityName")
                    onLocationSuccess(cityName)
                } else {
                    onLocationFailure()
                }
            } ?: kotlin.run {
                locationProvider.requestLocationUpdates(
                    locationRequest,
                    locationCallback,
                    mainLooper
                )
                onLocationFailure()
            }
        }.addOnFailureListener { onLocationFailure() }
    }

    abstract fun onLocationSuccess(cityName: String)
    abstract fun onLocationFailure()
    abstract fun onLocationRequestCanceled()

}