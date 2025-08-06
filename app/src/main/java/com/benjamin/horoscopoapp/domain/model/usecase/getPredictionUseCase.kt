package com.benjamin.horoscopoapp.domain.model.usecase

import com.benjamin.horoscopoapp.domain.model.Repository
import javax.inject.Inject

class getPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}