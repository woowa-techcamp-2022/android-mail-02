package org.woowatechcamp.mailapplication.presentation.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.woowatechcamp.mailapplication.util.MutableEventFlow
import org.woowatechcamp.mailapplication.util.asEventFlow

class AuthViewModel : ViewModel() {
    val nickname = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    private val _isNextBtnEnable = MutableEventFlow<Boolean>()
    val isNextBtnEnable
        get() = _isNextBtnEnable.asEventFlow()

    fun setNextBtnEnable(isEnable: Boolean) {
        viewModelScope.launch {
            _isNextBtnEnable.emit(isEnable)
        }
    }
}
