package com.benjamin.horoscopoapp.domain.model

import com.benjamin.horoscopoapp.R

sealed class HoroscopeInfo(val image: Int, val name : Int){
    data object Acuario: HoroscopeInfo(R.drawable.foto_aquario, R.string.Acuario)
    data object Piscis: HoroscopeInfo(R.drawable.foto_piscis, R.string.Piscis)
    data object Aries: HoroscopeInfo(R.drawable.foto_aries, R.string.Aries)
    data object Tauro: HoroscopeInfo(R.drawable.foto_tauro, R.string.Tauro)
    data object Geminis: HoroscopeInfo(R.drawable.foto_geminis, R.string.Geminis)
    data object Cancer: HoroscopeInfo(R.drawable.foto_cancer, R.string.Cancer)
    data object Leo: HoroscopeInfo(R.drawable.foto_leo, R.string.Leo)
    data object Virgo: HoroscopeInfo(R.drawable.foto_virgo, R.string.virgo)
    data object Libra: HoroscopeInfo(R.drawable.foto_libra, R.string.Libra)
    data object Scorpio: HoroscopeInfo(R.drawable.foto_escorpio, R.string.Escorpio)
    data object Sagitario: HoroscopeInfo(R.drawable.foto_sagitario, R.string.Sagitario)
    data object Capricornio: HoroscopeInfo(R.drawable.foto_capricornio, R.string.Capricornio)
}
