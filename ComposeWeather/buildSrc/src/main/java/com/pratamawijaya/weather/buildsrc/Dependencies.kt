package com.pratamawijaya.weather.buildsrc

object Libs {
    object Coroutines {
        private const val version = "1.5.0"
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Hilt {
        private const val version = "2.36"

        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object Compose {
        private const val version = "1.0.0-beta07"

        const val composeUi = "androidx.compose.ui:ui:$version"
        const val composeMaterial = "androidx.compose.material:material:$version"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val composeActivity = "androidx.activity:activity-compose:1.3.0-alpha08"
        const val composeConstraintLayout =
            "androidx.constraintlayout:constraintlayout-compose:1.0.0-beta07"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha01"
    }
}