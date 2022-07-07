package org.woowatechcamp.mailapplication.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.EditText
import org.woowatechcamp.mailapplication.R
import org.woowatechcamp.mailapplication.databinding.ActivitySignInBinding
import org.woowatechcamp.mailapplication.presentation.MainActivity
import org.woowatechcamp.mailapplication.util.base.BindingActivity
import org.woowatechcamp.mailapplication.util.ext.closeKeyboard

class SignInActivity : BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val view = currentFocus

        if (view != null && ev.action == MotionEvent.ACTION_UP || ev.action == MotionEvent.ACTION_MOVE && view is EditText && !view.javaClass.name.startsWith(
                "android.webkit."
            )
        ) {
            val locationList = IntArray(2)
            view.getLocationOnScreen(locationList)
            val x = ev.rawX + view.left - locationList[0]
            val y = ev.rawY + view.top - locationList[1]
            if (x < view.left || x > view.right || y < view.top || y > view.bottom) {
                closeKeyboard(view)
                view.clearFocus()
            }
        }

        return super.dispatchTouchEvent(ev)
    }
}
