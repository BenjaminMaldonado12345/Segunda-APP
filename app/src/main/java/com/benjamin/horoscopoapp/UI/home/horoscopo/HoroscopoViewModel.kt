package com.benjamin.horoscopoapp.UI.home.horoscopo

import androidx.lifecycle.ViewModel
import com.benjamin.horoscopoapp.data.providers.HoroscopeProvider
import com.benjamin.horoscopoapp.domain.model.HoroscopeInfo
import com.benjamin.horoscopoapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HoroscopoViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscope()
    }
}

