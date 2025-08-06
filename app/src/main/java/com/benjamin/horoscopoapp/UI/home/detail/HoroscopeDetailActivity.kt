package com.benjamin.horoscopoapp.UI.home.detail


import com.benjamin.horoscopoapp.R
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.benjamin.horoscopoapp.databinding.ActivityHoroscopeDetailBinding
import com.benjamin.horoscopoapp.domain.model.HoroscopeModel
import com.benjamin.horoscopoapp.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        initListener()
        initUIState()
    }

    private fun initListener() {
        binding.IMGBack.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle (Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect {
                    when(it){
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState(){
        binding.pb.isVisible = true
    }

    private fun errorState() {
        binding.pb.isVisible = false
        binding.TvBody.text = "Error al cargar el horóscopo"
        // También podés mostrar un Toast:
        Toast.makeText(this, "Ocurrió un error. Intenta de nuevo.", Toast.LENGTH_SHORT).show()
    }


    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.TvTittle.text = state.sign
        binding.TvBody.text = state.prediction

        val image = when(state.horoscopeModel){
            aquarius -> R.drawable.det_acuario
            pisces -> R.drawable.det_piscis
            aries -> R.drawable.det_aries
            taurus -> R.drawable.det_taurus
            gemini -> R.drawable.det_gemini
            cancer -> R.drawable.det_cancer
            leo -> R.drawable.det_leo
            libra -> R.drawable.det_libra
            virgo -> R.drawable.det_virgo
            scorpio -> R.drawable.det_scorpio
            sagittarius -> R.drawable.det_sagitario
            capricorn -> R.drawable.det_capricornio
        }
        binding.IMGDetail.setImageResource(image)
    }
}