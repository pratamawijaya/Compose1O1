package com.pratamawijaya.weather.presentation.ui.base

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.pratamawijaya.weather.presentation.utils.askPermission
import com.pratamawijaya.weather.presentation.utils.hasPermission
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import javax.inject.Inject

@AndroidEntryPoint
abstract class LocationActivity : AppCompatActivity() {

    @Inject
    lateinit var locationProvider: FusedLocationProviderClient

    @Inject
    lateinit var geoCoder: Geocoder

    companion object {
        const val RC_LOCATION = 100
    }

    private val perms = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    private val locationRequest: LocationRequest by lazy {
        LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 5 * 1000 // per 5 sec
        }
    }

    private val locationCallback: LocationCallback by lazy {
        object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                locationProvider.removeLocationUpdates(locationCallback)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!hasPermission(*perms)) {
            askPermission(RC_LOCATION, *perms)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.isNotEmpty() && grantResults.first() == PackageManager.PERMISSION_GRANTED) {
            getLocation()
        } else {
            onLocationRequestCancel()
        }
    }

    @SuppressLint("MissingPermission")
    protected fun getLocation() {
        d { "get location " }
        locationProvider.lastLocation.addOnSuccessListener { location ->
            location?.let {
                d { "get location from lat:${location.latitude} lng:${location.longitude} " }

                val cityName = geoCoder.getFromLocation(
                    location.latitude, location.longitude, 1
                ).firstOrNull()?.locality


                if (cityName != null) {
                    d { "location success $cityName" }
                    onLocationSuccess(cityName = cityName)
                } else {
                    e { "location failure" }
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
        }.addOnFailureListener {
            onLocationFailure()
        }
    }

    abstract fun onLocationSuccess(cityName: String)
    abstract fun onLocationFailure()
    abstract fun onLocationRequestCancel()
}