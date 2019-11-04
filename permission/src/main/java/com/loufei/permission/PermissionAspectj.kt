package com.loufei.permission

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

/**
 * Created by lvtengfei on 2019-10-29.
 */
@Aspect
class PermissionAspectj {

    @Pointcut("execution(@com.loufei.permission.Permissions * *(..)) && @annotation(permissions)")
    fun requestPermission(permissions: Permissions){
        Log.d("ASPECTJ","requestPermission")
    }

    @Around("requestPermission(permissions)")
    fun aroundJoinPonit(joinPoint: ProceedingJoinPoint,permissions: Permissions){
        var context:Context? = null
        when (val any = joinPoint.`this`) {
            is Context -> context = any
            is Fragment -> context = any.activity
            is android.app.Fragment -> context = any.activity
            is View -> context = any.context
            is Activity -> context = any
        }

        context?:let { throw RuntimeException("请在Activity、Fragment、androidx.fragment.app.Fragment中使用") }
        context?.let { context1 ->
            PermissionActivity.requestPermissions(context1,permissions.permissions,object:IPermission{
                override fun onGranted() {
                    joinPoint.proceed()
                }

                override fun onDenied(deniedPermissions: Array<String>) {
                    val javaClass = joinPoint.`this`.javaClass
                    val declaredMethods = javaClass.declaredMethods
                    declaredMethods.forEach {
                        it.takeIf { it.isAnnotationPresent(PermissionDenied::class.java) }?.apply {
                            it.isAccessible = true
                            it.invoke(joinPoint.`this`)
                        }
                    }
                }

                override fun canceled() {
                    val javaClass = joinPoint.`this`.javaClass
                    val declaredMethods = javaClass.declaredMethods
                    declaredMethods.forEach {
                        it.takeIf { it.isAnnotationPresent(PermissionCanceled::class.java) }?.apply {
                            it.isAccessible = true
                            it.invoke(joinPoint.`this`)
                        }
                    }
                }
            })
        }
    }
}