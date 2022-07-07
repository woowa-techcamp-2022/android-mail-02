package org.woowatechcamp.mailapplication.presentation.auth

import android.os.Bundle
import android.view.MotionEvent
import android.widget.EditText
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.woowatechcamp.mailapplication.R
import org.woowatechcamp.mailapplication.data.model.EMAIL
import org.woowatechcamp.mailapplication.data.model.NICKNAME
import org.woowatechcamp.mailapplication.databinding.ActivitySignInBinding
import org.woowatechcamp.mailapplication.presentation.MainActivity
import org.woowatechcamp.mailapplication.util.LoginCheckPatternUtil.isNotValidEmail
import org.woowatechcamp.mailapplication.util.LoginCheckPatternUtil.isNotValidName
import org.woowatechcamp.mailapplication.util.base.BindingActivity
import org.woowatechcamp.mailapplication.util.ext.closeKeyboard
import org.woowatechcamp.mailapplication.util.ext.startActivity

class SignInActivity : BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private val viewModel by viewModels<AuthViewModel>()
    private var isNickNameValid = false
    private var isEmailValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClickEvent()
        initTextChangeListener()
        observeData()
    }

    private fun initClickEvent() {
        with(binding) {
            btnNext.setOnClickListener {
                startActivity<MainActivity>(
                    Pair(EMAIL, etEmail.text.toString()),
                    Pair(NICKNAME, etNickname.text.toString())
                )
                finish()
            }
        }
    }

    private fun initTextChangeListener() {
        with(binding) {
            etNickname.addTextChangedListener {
                if (isNotValidName(etNickname.text.toString())) {
                    layoutNickname.error = getString(R.string.nickname_error)
                    isNickNameValid = false
                } else {
                    layoutNickname.error = null
                    isNickNameValid = true
                }
                viewModel.setNextBtnEnable(isValid())
            }
            etEmail.addTextChangedListener {
                if (isNotValidEmail(etEmail.text.toString())) {
                    layoutEmail.error = getString(R.string.email_error)
                    isEmailValid = false
                } else {
                    layoutEmail.error = null
                    isEmailValid = true
                }
                viewModel.setNextBtnEnable(isValid())
            }
        }
    }

    private fun observeData() {
        viewModel.isNextBtnEnable.flowWithLifecycle(lifecycle)
            .onEach {
                binding.btnNext.isEnabled = it
            }.launchIn(lifecycleScope)
    }

    private fun isValid() = isNickNameValid && isEmailValid

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
