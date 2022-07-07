package org.woowatechcamp.mailapplication.presentation

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.woowatechcamp.mailapplication.R
import org.woowatechcamp.mailapplication.data.model.PRIMARY
import org.woowatechcamp.mailapplication.data.model.PROMOTION
import org.woowatechcamp.mailapplication.data.model.SOCIAL
import org.woowatechcamp.mailapplication.databinding.ActivityMainBinding
import org.woowatechcamp.mailapplication.presentation.mail.MailFragment
import org.woowatechcamp.mailapplication.presentation.setting.SettingFragment
import org.woowatechcamp.mailapplication.util.base.BindingActivity
import org.woowatechcamp.mailapplication.util.ext.replace

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigation()
        initBottomNavigation()
        initNavigationRail()
        observeData()
    }

    private fun observeData() {
        viewModel.selectCategory.flowWithLifecycle(lifecycle)
            .onEach {
                setItemSelect(it)
            }
            .launchIn(lifecycleScope)

        viewModel.selectMenu.flowWithLifecycle(lifecycle)
            .onEach {
                binding.bnvMain?.let { bnv ->
                    bnv.menu.findItem(it).isChecked = true
                }
                binding.navMain?.let { bnv ->
                    bnv.menu.findItem(it).isChecked = true
                }
                replaceFragment(it)
            }
            .launchIn(lifecycleScope)
    }

    private fun initNavigation() {
        with(binding) {
            tbMain.setNavigationOnClickListener {
                dlMail.open()
            }

            nvMail.setNavigationItemSelectedListener {
                dlMail.close()

                viewModel.setMenuSelect(R.id.menu_mail)
                viewModel.setCategorySelect(
                    when (it.itemId) {
                        R.id.item_primary -> PRIMARY
                        R.id.item_social -> SOCIAL
                        else -> PROMOTION
                    }
                )
                true
            }
        }
    }

    private fun setItemSelect(category: Int) {
        with(binding.nvMail.menu) {
            when (category) {
                PRIMARY -> findItem(R.id.item_primary).isChecked = true
                SOCIAL -> findItem(R.id.item_social).isChecked = true
                else -> findItem(R.id.item_promotion).isChecked = true
            }
        }
    }

    private fun initBottomNavigation() {
        binding.bnvMain?.setOnItemSelectedListener {
            viewModel.setMenuSelect(it.itemId)
            true
        }
    }

    private fun initNavigationRail() {
        binding.navMain?.setOnItemSelectedListener {
            viewModel.setMenuSelect(it.itemId)
            true
        }
    }

    private fun replaceFragment(itemId: Int) {
        when (itemId) {
            R.id.menu_mail -> replace<MailFragment>(R.id.container_main)
            else -> {
                viewModel.setCategorySelect(PRIMARY)
                replace<SettingFragment>(R.id.container_main)
            }
        }
    }

    private fun initBackPressedLogic(menu: Menu?) {
        menu?.let {
            if (it.findItem(R.id.menu_setting).isChecked)
                viewModel.setMenuSelect(R.id.menu_mail)
            else {
                with(binding.dlMail) {
                    if (isOpen)
                        close()
                    else {
                        if (binding.nvMail.menu.findItem(R.id.item_primary).isChecked)
                            super.onBackPressed()
                        else
                            viewModel.setCategorySelect(PRIMARY)
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        initBackPressedLogic(binding.bnvMain?.menu)
        initBackPressedLogic(binding.navMain?.menu)
    }
}
