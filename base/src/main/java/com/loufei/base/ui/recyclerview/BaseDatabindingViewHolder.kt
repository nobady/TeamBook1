package com.loufei.base.ui.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by lvtengfei on 2019-12-19.
 */
class BaseDatabindingViewHolder<out T:ViewDataBinding>(public val binding: T) :RecyclerView.ViewHolder(binding.root)