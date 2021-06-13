package com.pratamawijaya.weather.buildsrc

object Libs {
    object Coroutines {
        private const val version = "1.5.0"
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Hilt {
        private const val version = "2.36"

        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object Compose {
        const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha01"
    }
}