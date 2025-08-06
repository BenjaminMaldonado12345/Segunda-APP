package com.benjamin.horoscopoapp.data.providers

import android.util.Log
import com.benjamin.horoscopoapp.data.providers.network.HoroscopeApiService
import com.benjamin.horoscopoapp.domain.model.PredictionModel
import com.benjamin.horoscopoapp.domain.model.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String) : PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain()}
            .onFailure { Log.i("Benja", "Ha ocurrido un error ${it.message}") }

        return null
    }
}