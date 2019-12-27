package com.loufei.teambook.navigator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

/**
 * Created by lvtengfei on 2019-12-26.
 */
class TabNavigator(context: Context, manager: FragmentManager, id: Int) :
    FragmentNavigator(context, manager, id) {

    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        return super.navigate(destination, args, navOptions, navigatorExtras)
    }
}