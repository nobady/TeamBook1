package com.loufei.base.ui.activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.loufei.base.R
import com.loufei.base.ext.contentView
import com.loufei.base.ui.BaseViewModel

/**
 * Created by lvtengfei on 2019-10-22.
 */
abstract class BaseVMActivity<VM : BaseViewModel,T:ViewDataBinding> : AppCompatActivity(), LifecycleObserver {

    lateinit var mViewModel: VM
    var mToolbar:Toolbar? = null
    lateinit var binding:T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setWindowColor()
        initVM()
        startObserve()
        binding = DataBindingUtil.setContentView(this,getLayoutResId())
        binding.lifecycleOwner = this
        initView()
        initData()
    }

    @SuppressLint("ResourceType")
    protected fun setWindowColor(){
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = resources.getColor(R.color.main_color)
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()

    fun initToolbar(){
        mToolbar = findViewById<Toolbar>(R.id.mToolbar)
        mToolbar?.let {
            setSupportActionBar(it)
        }
        setToolbar()
    }

    open fun setToolbar(){

    }

    private fun initVM() {
        providerVMClass()?.let {
            mViewModel = ViewModelProviders.of(this).get(it)
            mViewModel.let(lifecycle::addObserver)
        }
    }

    open fun providerVMClass(): Class<VM>? = null


    open fun startObserve() {
        mViewModel.mException.observe(this, Observer { it?.let { onError(it) } })
    }

    open fun onError(e: Throwable) {}

    override fun onDestroy() {
        mViewModel.let {
            lifecycle.removeObserver(it)
        }
        super.onDestroy()
    }
}