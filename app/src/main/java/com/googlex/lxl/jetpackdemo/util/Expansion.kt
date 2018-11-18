package com.googlex.lxl.jetpackdemo.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import java.util.concurrent.Executors

fun Context.toast(value: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, value, duration).show()
}

fun Context.jumpTo(t: Class<Any>, bundle: Bundle = Bundle()) {
    var intent = Intent(this, t)
    intent.putExtras(bundle)
    startActivity(intent)
}

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun runOnIoThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}