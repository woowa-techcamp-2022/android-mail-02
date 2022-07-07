package org.woowatechcamp.mailapplication.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.woowatechcamp.mailapplication.R
import org.woowatechcamp.mailapplication.data.model.PRIMARY
import org.woowatechcamp.mailapplication.data.model.SOCIAL
import org.woowatechcamp.mailapplication.util.ext.getColor
import org.woowatechcamp.mailapplication.util.ext.getString

@BindingAdapter("category")
fun TextView.setCategoryText(category: Int) {
    text = when (category) {
        PRIMARY -> getString(R.string.primary)
        SOCIAL -> getString(R.string.social)
        else -> getString(R.string.promotions)
    }
}

@BindingAdapter("isEnglish")
fun ImageView.setProfileSrc(isEnglish: Boolean) {
    if (!isEnglish) {
        setBackgroundColor(getColor(R.color.grey_500))
        setImageResource(R.drawable.ic_person_24)
    } else
        setImageResource(0)
}
