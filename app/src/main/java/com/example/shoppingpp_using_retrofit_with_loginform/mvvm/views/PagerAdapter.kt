package com.example.shoppingpp_using_retrofit_with_loginform

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views.PasswordUpdateFragment
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views.ProfileFragment

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val count = 2

    override fun getCount(): Int {
        return count
    }
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ProfileFragment()
            else -> PasswordUpdateFragment()
        }
    }
    override fun getPageTitle(position: Int): CharSequence?{
        return when (position) {
            0 -> {
                "PROFILE"
            }
            else -> {
                "PASSWORD"
            }
        }
    }
}
