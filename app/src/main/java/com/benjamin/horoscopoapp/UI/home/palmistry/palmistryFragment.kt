package com.benjamin.horoscopoapp.UI.home.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benjamin.horoscopoapp.R
import com.benjamin.horoscopoapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class palmistryFragment : Fragment() {

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}