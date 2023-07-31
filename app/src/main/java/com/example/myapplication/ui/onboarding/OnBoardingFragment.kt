package com.example.myapplication.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentOnBoardingBinding
import com.example.myapplication.ui.data.local.Pref
import com.example.myapplication.ui.onboarding.adapter.OnBoardingAdapter


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var adapter : OnBoardingAdapter
    private val pref: Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardingAdapter(this::onClick)
        binding.viewpager.adapter = adapter

        binding.indicator.setViewPager(binding.viewpager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }

    private fun onClick(){
        pref.onOnBoardingShowed()
        findNavController().navigateUp()
    }

}