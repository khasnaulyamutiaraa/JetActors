package com.khasna.jetactors.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khasna.jetactors.ui.screen.detail.DetailViewModel
import com.khasna.jetactors.ui.screen.home.HomeViewModel
import com.khasna.jetactors.repository.ActorsRepository

class ViewModelFactory(private val repository: ActorsRepository):
    ViewModelProvider.NewInstanceFactory(){


    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}