package com.example.viewmodelscoping.util

import android.content.Context
import android.content.res.Configuration
import com.example.viewmodelscoping.R

fun isTablet(context: Context?): Boolean = try {
    context?.let {
        context.resources?.getBoolean(R.bool.isTablet)
    } ?: false

} catch (ex: Exception) {
    false
}

fun Context?.isLandscape(): Boolean = try {
    this?.resources?.configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE
} catch (ex: Exception) {
    false
}
