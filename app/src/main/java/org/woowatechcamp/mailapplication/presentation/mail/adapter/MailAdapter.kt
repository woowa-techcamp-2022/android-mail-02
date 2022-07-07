package org.woowatechcamp.mailapplication.presentation.mail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.woowatechcamp.mailapplication.databinding.ItemMailBinding
import org.woowatechcamp.mailapplication.domain.entity.MailInfo
import org.woowatechcamp.mailapplication.util.ItemDiffCallback
import org.woowatechcamp.mailapplication.util.ext.getColor

class MailAdapter : ListAdapter<MailInfo, MailAdapter.MailViewHolder>(
    ItemDiffCallback<MailInfo>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.hashCode() == new.hashCode() }
    )
) {
    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        if (!::inflater.isInitialized)
            inflater = LayoutInflater.from(parent.context)

        val binding = ItemMailBinding.inflate(inflater, parent, false)
        return MailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class MailViewHolder(
        private val binding: ItemMailBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MailInfo) {
            with(binding) {
                isTextVisible = false
                this.data = data
                with(ivProfile) {
                    data.profileColor?.let {
                        isTextVisible = true
                        setBackgroundColor(getColor(it))
                    }
                }
            }
        }
    }
}
