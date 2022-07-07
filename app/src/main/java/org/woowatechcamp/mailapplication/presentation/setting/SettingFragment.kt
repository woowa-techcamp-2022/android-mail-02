package org.woowatechcamp.mailapplication.presentation.setting

import android.os.Bundle
import android.view.View
import org.woowatechcamp.mailapplication.R
import org.woowatechcamp.mailapplication.data.model.EMAIL
import org.woowatechcamp.mailapplication.data.model.NICKNAME
import org.woowatechcamp.mailapplication.databinding.FragmentSettingBinding
import org.woowatechcamp.mailapplication.util.base.BindingFragment

class SettingFragment : BindingFragment<FragmentSettingBinding>(R.layout.fragment_setting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        with(requireActivity().intent) {
            binding.email = getStringExtra(EMAIL)
            binding.nickname = getStringExtra(NICKNAME)
        }
    }
}
