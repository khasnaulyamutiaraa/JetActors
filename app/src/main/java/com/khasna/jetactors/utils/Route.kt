package com.khasna.jetactors.utils

sealed class Route(val path: String){
    object Home: Route("home")
    object About: Route("about")
    object  Detail: Route("home/{actorsId}") {
        fun createRoute(actorsId: String)  = "home/$actorsId"
    }
}
