package org.woowatechcamp.mailapplication.presentation

import android.os.Bundle
import org.woowatechcamp.mailapplication.R
import org.woowatechcamp.mailapplication.databinding.ActivityMainBinding
import org.woowatechcamp.mailapplication.presentation.mail.MailFragment
import org.woowatechcamp.mailapplication.presentation.setting.SettingFragment
import org.woowatechcamp.mailapplication.util.base.BindingActivity
import org.woowatechcamp.mailapplication.util.ext.replace

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(R.id.menu_mail)
        initNavigation()
        initBottomNavigation()
    }

    private fun initNavigation() {
        with(binding) {
            tbMain.setNavigationOnClickListener {
                dlMail.open()
            }

            nvMail.setNavigationItemSelectedListener {
                it.isChecked = true
                dlMail.close()
                true
            }
        }
    }

    private fun initBottomNavigation() {
        binding.bnvMain.setOnItemSelectedListener {
            replaceFragment(it.itemId)
            true
        }
    }

    private fun replaceFragment(itemId: Int) {
        when (itemId) {
            R.id.menu_mail -> replace<MailFragment>(R.id.container_main)
            else -> replace<SettingFragment>(R.id.container_main)
        }
    }

    override fun onBackPressed() {
        with(binding.dlMail) {
            if (isOpen)
                close()
            else
                super.onBackPressed()
        }
    }
}
