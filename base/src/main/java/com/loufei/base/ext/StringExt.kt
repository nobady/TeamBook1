package com.loufei.base.ext

import java.util.regex.Pattern

/**
 * Created by lvtengfei on 2019-10-23.
 */
/**
 * if [String.isNullOrEmpty], invoke f()
 * otherwise invoke t()
 */
fun <T> String?.notNull(f: () -> T, t: () -> T): T {
    return if (isNullOrEmpty()) f() else t()
}

/**
 * whether string only contains digits
 */
fun String.areDigitsOnly() = matches(Regex("[0-9]+"))

fun String.isPhoneNumber():Boolean {
    if (length==11){
        return matches(Regex("^1[3|4|5|6|7|8|9][0-9]\\d{8}"))
    }
    return false
}