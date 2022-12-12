package com.example.android_kotlin_two.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.android_kotlin_two.R
import com.example.android_kotlin_two.databinding.FragmentOnBoardBinding


class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize()= with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                onTxt.text = "Очень удобный функционал"
                lottieFirst.setAnimation(R.raw.lottie1)
            }

            1 -> {
                onTxt.text = "Быстрый, качественный продукт"
                lottieFirst.setAnimation(R.raw.image)
            }

            2 -> {
                onTxt.text = "Куча функций и, фишек"
                lottieFirst.setAnimation(R.raw.imagee)
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "oBoard"
    }
}
