package org.woowatechcamp.mailapplication.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.woowatechcamp.mailapplication.R
import org.woowatechcamp.mailapplication.data.model.PRIMARY
import org.woowatechcamp.mailapplication.domain.MailRepository
import org.woowatechcamp.mailapplication.domain.entity.MailInfo
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mailRepository: MailRepository) : ViewModel() {
    private val _selectCategory = MutableStateFlow(PRIMARY)
    val selectCategory
        get() = _selectCategory.asStateFlow()

    private val _selectMenu = MutableStateFlow(R.id.menu_mail)
    val selectMenu
        get() = _selectMenu.asStateFlow()

    private val _mailList = MutableStateFlow<List<MailInfo>>(listOf())
    val mailList: StateFlow<List<MailInfo>>
        get() = _mailList.asStateFlow()

    fun getMailList(category: Int) {
        _mailList.value = mailRepository.getMail().filter { it.category == category }
    }

    fun setCategorySelect(category: Int) {
        _selectCategory.value = category
    }

    fun setMenuSelect(menu: Int) {
        _selectMenu.value = menu
    }
}
