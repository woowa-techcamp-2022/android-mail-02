package org.woowatechcamp.mailapplication.presentation.mail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.woowatechcamp.mailapplication.R
import org.woowatechcamp.mailapplication.databinding.FragmentMailBinding
import org.woowatechcamp.mailapplication.presentation.MainViewModel
import org.woowatechcamp.mailapplication.presentation.mail.adapter.MailAdapter
import org.woowatechcamp.mailapplication.util.base.BindingFragment

class MailFragment : BindingFragment<FragmentMailBinding>(R.layout.fragment_mail) {
    private val viewModel: MainViewModel by activityViewModels()
    private var mailAdapter: MailAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeData()
    }

    private fun initAdapter() {
        mailAdapter = MailAdapter()
        binding.rvMail.adapter = mailAdapter
    }

    private fun observeData() {
        viewModel.selectCategory.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                viewModel.getMailList(it)
                binding.category = it
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.mailList.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                mailAdapter?.submitList(it)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mailAdapter = null
    }
}
