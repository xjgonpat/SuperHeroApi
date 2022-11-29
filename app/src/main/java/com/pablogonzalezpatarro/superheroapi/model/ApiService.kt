package com.pablogonzalezpatarro.superheroapi.model

import retrofit2.http.GET
import retrofit2.http.Url

//Creamos la interfaz con la que voy a obtener los resultados.
interface ApiService {
    @GET
    suspend fun getHeroById (@Url id: String)

    @GET
    suspend fun getAllHeroes(@Url p:String) : Results
}