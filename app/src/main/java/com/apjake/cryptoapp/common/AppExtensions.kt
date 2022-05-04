package com.apjake.cryptoapp.common

fun Boolean?.orFalse(): Boolean = this?:false
fun Int?.orZero(): Int = this?:0