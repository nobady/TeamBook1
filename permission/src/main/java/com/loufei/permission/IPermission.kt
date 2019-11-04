package com.loufei.permission

/**
 * Created by lvtengfei on 2019-10-29.
 */
interface IPermission {
    fun onGranted()
    fun onDenied(deniedPermissions:Array<String>)
    fun canceled()
}