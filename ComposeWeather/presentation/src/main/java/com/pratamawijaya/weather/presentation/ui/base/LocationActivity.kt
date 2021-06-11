package com.pratamawijaya.weather.presentation.ui.base

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

//@AndroidEntryPoint
abstract class LocationActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

//    @Inject
    lateinit var locationProvider: FusedLocationProviderClient

//    @Inject
    lateinit var geoCoder: Geocoder

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
        // check permission

        val perms = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        if (!EasyPermissions.hasPermissions(this, *perms)) {
            // jika tidak punya permission
            EasyPermissions.requestPermissions(this, "Membutuhkan permission location", 100, *perms)
        }

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        Log.d("debug", "permission granted")

        getLocation()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        Log.e("debug", "permission denied")
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // forward result
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    @SuppressLint("MissingPermission")
    protected fun getLocation() {
        locationProvider.lastLocation.addOnSuccessListener { location ->
            location?.let {
                val cityName = geoCoder.getFromLocation(
                    location.latitude, location.longitude, 1
                ).firstOrNull()?.locality

                if (cityName != null) {
                    onLocationSuccess(cityName = cityName)
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
        }.addOnFailureListener {
            onLocationFailure()
        }
    }

    abstract fun onLocationSuccess(cityName: String)
    abstract fun onLocationFailure()
}