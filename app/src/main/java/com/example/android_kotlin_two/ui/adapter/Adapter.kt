package com.example.android_kotlin_two.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_kotlin_two.ui.fragment.OnBoardFragment
import com.example.android_kotlin_two.ui.fragment.OnBoardFragment.Companion.ARG_ONBOARD_POSITION

class Adapter(
    fragment: Fragment
):FragmentStateAdapter(fragment){

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)

        }
    }
}