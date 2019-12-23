package com.loufei.base.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by lvtengfei on 2019-12-19.
 */
abstract class BaseBindingAdapter<T, V : ViewDataBinding> :
    RecyclerView.Adapter<BaseDatabindingViewHolder<V>>() {


    abstract val layoutId: Int
    protected val mData = ArrayList<T>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseDatabindingViewHolder<V> {
        return BaseDatabindingViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }
    override fun getItemCount() = mData.size

    override fun onBindViewHolder(holder: BaseDatabindingViewHolder<V>, position: Int) {
        initView(holder.binding,mData[position])
        holder.binding.executePendingBindings()
    }

    abstract fun initView(binding: V, data: T)

    fun addAll(list: List<T>, isFirst: Boolean) {
        if (isFirst) mData.clear()
        mData.addAll(list)
        notifyDataSetChanged()
    }

    fun getData(): List<T> {
        return mData
    }
}