package com.benjamin.horoscopoapp.UI.home.horoscopo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.benjamin.horoscopoapp.R
import com.benjamin.horoscopoapp.UI.home.horoscopo.adapter.HoroscopeAdapter
import com.benjamin.horoscopoapp.databinding.FragmentHoroscopoBinding
import com.benjamin.horoscopoapp.domain.model.HoroscopeInfo
import com.benjamin.horoscopoapp.domain.model.HoroscopeInfo.*
import com.benjamin.horoscopoapp.domain.model.HoroscopeModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopoViewModel>()

    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initList()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {

            val type = when(it){
                Acuario -> HoroscopeModel.aquarius
                Aries -> HoroscopeModel.aries
                Cancer -> HoroscopeModel.cancer
                Capricornio -> HoroscopeModel.capricorn
                Geminis -> HoroscopeModel.gemini
                Leo -> HoroscopeModel.leo
                Libra -> HoroscopeModel.libra
                Piscis -> HoroscopeModel.pisces
                Sagitario -> HoroscopeModel.sagittarius
                Scorpio -> HoroscopeModel.scorpio
                Tauro -> HoroscopeModel.taurus
                Virgo -> HoroscopeModel.virgo
            }

            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToHoroscopeDetailActivity(type)
            )
        })

        binding.RvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeViewModel.horoscope.collect {
                    //CAMBIOS EN HOROSCOPE
                    horoscopeAdapter.update(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}