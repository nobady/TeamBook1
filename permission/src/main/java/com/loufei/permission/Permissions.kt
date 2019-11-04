package com.loufei.permission

/**
 * Created by lvtengfei on 2019-10-28.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Permissions(val permissions:Array<String>)




