package com.khasna.jetactors.repository

import com.khasna.jetactors.model.Actors
import com.khasna.jetactors.model.ActorsData

class ActorsRepository {
    fun getActorsData(): List<Actors> = ActorsData.actors

    fun getActorsById(id: String): Actors = ActorsData.actors.find {
        it.id == id
    } as Actors
}