package com.pablogonzalezpatarro.superheroapi.model


import com.pablogonzalezpatarro.superheroapi.Hero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RemoteConnection {

    //Construimos una instancia de retrofit. Enviamos la url base y la apikey en este momento
    // por claridad de código.
    private val builder: Retrofit = Retrofit.Builder()
        .baseUrl("https://akabab.github.io/superhero-api/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //Función asíncrona que me devuelve los resultados de la consulta a la api.
     val results: ApiService = builder.create(ApiService::class.java)


     val fakeResult:List<Hero> = (1..10).map{
        Hero(it,"nombre $it","masculino",null)
    }


    //Creamos una función que recibe un parámetro para cada llamada a la api.
    //Dentro de esta función hacemos la corrutina.
    suspend fun searchById(id:Int) {
        //Me devuelve null a todas las llamadas.
        var resHero  = null
        CoroutineScope(Dispatchers.IO).launch {


        }

        //Creamos el objeto de la clase Hero y lo devolvemos.
        //Hacemos este paso aquí por comodidad.
        /*
        return Hero(
            resHero?.id,
            resHero?.name,
            resHero?.appearance?.gender,
            resHero?.images?.md)
        */
    }
}