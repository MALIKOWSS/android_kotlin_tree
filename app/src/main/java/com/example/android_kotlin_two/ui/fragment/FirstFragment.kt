package com.example.android_kotlin_two.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.android_kotlin_two.databinding.FragmentFirstBinding
import com.example.android_kotlin_two.ui.adapter.RecyclerAdapter
import com.example.android_kotlin_two.util.SharedPrefer
import com.google.android.material.tabs.TabLayoutMediator


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        clickButton()
        viewPager()
        click()
        cashSave()
        TabLayoutMediator(binding.ui, binding.viewPager) { it, it2 ->
        }.attach()
    }

    private fun click() {
        binding.two.setOnClickListener {
            findNavController().navigate(com.example.android_kotlin_two.R.id.action_firstFragment2_to_homeFragment)
        }
    }

    private fun initialize() {
        binding.viewPager.adapter = RecyclerAdapter(this@FirstFragment)
    }

    private fun viewPager() {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.two.text = ""
                        binding.nextButton.isVisible = true
                    }

                    1 -> {
                        binding.two.text = ""
                        binding.nextButton.isVisible = true
                    }

                    2 -> {
                        binding.two.text = "Начать работу"
                        binding.nextButton.isVisible = false
                    }
                }
            }
        })
    }

    private fun clickButton() = with(binding.viewPager) {
        binding.nextButton.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 1, true)
            }
        }
    }

    private fun cashSave() {
        if (SharedPrefer.isShows) {
            SharedPrefer.isShows = false
        } else {
            findNavController().navigateUp()
        }
    }
}