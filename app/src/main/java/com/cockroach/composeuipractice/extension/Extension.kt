package com.cockroach.composeuipractice.extension

import android.content.res.Resources

val Int.toDp get() = (this / Resources.getSystem().displayMetrics.density).toInt()
