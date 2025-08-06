package com.benjamin.horoscopoapp.data.providers

import com.benjamin.horoscopoapp.domain.model.HoroscopeInfo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor(){
    fun getHoroscope(): List<HoroscopeInfo>{
        return listOf(
            HoroscopeInfo.Acuario,
            HoroscopeInfo.Piscis,
            HoroscopeInfo.Aries,
            HoroscopeInfo.Tauro,
            HoroscopeInfo.Geminis,
            HoroscopeInfo.Cancer,
            HoroscopeInfo.Leo,
            HoroscopeInfo.Virgo,
            HoroscopeInfo.Libra,
            HoroscopeInfo.Scorpio,
            HoroscopeInfo.Sagitario,
            HoroscopeInfo.Capricornio
        )
    }
}