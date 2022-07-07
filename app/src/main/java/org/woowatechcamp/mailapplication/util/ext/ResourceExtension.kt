package org.woowatechcamp.mailapplication.util.ext

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.StringRes

fun View.getColor(@ColorRes res: Int) = context.getColor(res)
fun View.getString(@StringRes res: Int) = context.getString(res)
