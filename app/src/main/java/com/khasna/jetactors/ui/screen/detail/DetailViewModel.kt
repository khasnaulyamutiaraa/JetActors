package com.khasna.jetactors.ui.screen.detail

import androidx.lifecycle.ViewModel
import com.khasna.jetactors.model.Actors
import com.khasna.jetactors.repository.ActorsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(private val actorsRepository: ActorsRepository) : ViewModel() {
    fun getActorsData(idActors: String): StateFlow<Actors> = MutableStateFlow(
       actorsRepository.getActorsById(idActors)
    ).asStateFlow()
}