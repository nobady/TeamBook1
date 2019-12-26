package com.loufei.teambook.ui.login

import android.graphics.Typeface
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.tabs.TabLayout
import com.loufei.base.ext.contentView
import com.loufei.base.ui.activity.BaseVMActivity
import com.loufei.teambook.R
import com.loufei.teambook.databinding.ActivityLogin1Binding
import com.loufei.teambook.ui.login.view_model.LoginViewModel

/**
 * Created by lvtengfei on 2019-12-23.
 */
class LoginActivity1 : BaseVMActivity<LoginViewModel,ActivityLogin1Binding>() {

    private val arrayTitle = arrayOf(R.string.next_login, R.string.register)
    private var mCurrentFragmentTag = ""

    override fun getLayoutResId() = R.layout.activity_login1

    override fun providerVMClass() = LoginViewModel::class.java

    override fun initView() {
        window.statusBarColor = resources.getColor(R.color.white)
        binding.model = mViewModel
        binding.lifecycleOwner = this
        setTabLayout()
    }

    private fun changeOrNewFragment(position: Int) {
        val oldFragment = supportFragmentManager.findFragmentByTag(mCurrentFragmentTag)
        var newFragment =
            supportFragmentManager.findFragmentByTag(getString(arrayTitle[position]))

        newFragment ?: run {
            newFragment = when (position) {
                0 -> LoginFragment()
                else -> LoginFragment()
            }
        }
        newFragment?.takeIf { oldFragment != it }?.let { frag ->
            val beginTransaction = supportFragmentManager.beginTransaction()
            oldFragment?.takeIf { it.isAdded }?.let { beginTransaction.hide(it) }
            frag.takeIf { it.isAdded }?.let { beginTransaction.show(it) }
            frag.takeUnless { it.isAdded }?.let { beginTransaction.add(R.id.frameLayout, it, getString(arrayTitle[position])) }
            beginTransaction.commitAllowingStateLoss()
            mCurrentFragmentTag = getString(arrayTitle[position])
        }
    }


    private fun setTabLayout() {

        binding.tabLayoutLogin.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.let {
                    val textView = it.findViewById<TextView>(R.id.tv_tabItem_text)
                    textView.setTextColor(resources.getColor(R.color.second_text_color))
                    textView.typeface = Typeface.DEFAULT
                    textView.textSize = 18F
                    it.findViewById<ImageView>(R.id.indicator_iv).visibility = View.GONE
                }
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.let {
                    val textView = it.findViewById<TextView>(R.id.tv_tabItem_text)
                    textView.setTextColor(resources.getColor(R.color.main_text_color))
                    textView.typeface = Typeface.DEFAULT_BOLD
                    textView.textSize = 20F
                    it.findViewById<ImageView>(R.id.indicator_iv).visibility = View.VISIBLE
                    changeOrNewFragment(tab.position)
                    mViewModel.changeFragment(tab.position)
                }
            }
        })
        repeat(2) {
            val newTab = binding.tabLayoutLogin.newTab()
            val view = LayoutInflater.from(this).inflate(R.layout.layout_tab_item, null, false)
            view.findViewById<TextView>(R.id.tv_tabItem_text).setText(arrayTitle[it])
            newTab.customView = view
            binding.tabLayoutLogin.addTab(newTab)
        }
        binding.tabLayoutLogin.getChildAt(0).isSelected = true
    }

    override fun initData() {
    }

}