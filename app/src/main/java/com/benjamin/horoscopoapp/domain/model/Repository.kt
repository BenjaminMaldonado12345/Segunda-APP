package com.benjamin.horoscopoapp.domain.model



interface Repository {
    suspend fun getPrediction(sign: String) : PredictionModel?
}