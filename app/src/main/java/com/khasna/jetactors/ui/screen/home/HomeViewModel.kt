package com.khasna.jetactors.ui.screen.home

import androidx.lifecycle.ViewModel
import com.khasna.jetactors.model.Actors
import com.khasna.jetactors.repository.ActorsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(actorsRepository: ActorsRepository) : ViewModel()  {
    private val _actors = MutableStateFlow(
        actorsRepository.getActorsData()
    )

    val actors: StateFlow<List<Actors>> get() = _actors.asStateFlow()
}