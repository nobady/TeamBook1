package com.loufei.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * Created by lvtengfei on 2019-10-22.
 */
abstract class BaseFragment : androidx.fragment.app.Fragment(), CoroutineScope by MainScope() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initData()
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun getLayoutResId(): Int

    abstract fun initView()

    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}