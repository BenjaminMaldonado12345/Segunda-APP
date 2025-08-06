package com.benjamin.horoscopoapp.UI.home.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benjamin.horoscopoapp.domain.model.HoroscopeModel
import com.benjamin.horoscopoapp.domain.model.usecase.getPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: getPredictionUseCase) :
    ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope: HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel){
        horoscope = sign
        viewModelScope.launch {
            //Todo lo que se haga aca es, hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO){ getPredictionUseCase(sign.name) } //Y todo lo que se haga dentro de withContext es hilo secundario
            //Hilo principal
            if (result!=null){
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            }else{
                _state.value = HoroscopeDetailState.Error("Ha ocurrido un error")
            }
        }
    }
}