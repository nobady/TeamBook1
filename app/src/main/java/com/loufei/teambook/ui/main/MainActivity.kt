package com.loufei.teambook.ui.main

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.loufei.base.ext.contentView
import com.loufei.base.ui.activity.BaseVMActivity
import com.loufei.teambook.R
import com.loufei.teambook.databinding.ActivityMainBinding
import com.loufei.teambook.ui.main.viewmodel.MainViewModel

class MainActivity : BaseVMActivity<MainViewModel,ActivityMainBinding>() {

    override fun getLayoutResId() = R.layout.activity_main

    override fun providerVMClass() = MainViewModel::class.java

    override fun initView() {
        binding.lifecycleOwner = this
        binding.mainModel = mViewModel
    }

    override fun initData() {
        val navController = Navigation.findNavController(this, R.id.frag_nav_navigation)
        NavigationUI.setupWithNavController(binding.homeBottomNavigation,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.frag_nav_navigation).navigateUp()
    }

}
