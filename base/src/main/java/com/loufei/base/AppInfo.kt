package com.loufei.base

import android.graphics.drawable.Drawable

/**
 * Created by lvtengfei on 2019-10-23.
 */
data class AppInfo(
        val apkPath: String,
        val packageName: String,
        val versionName: String,
        val versionCode: Long,
        val appName: String,
        val icon: Drawable
)