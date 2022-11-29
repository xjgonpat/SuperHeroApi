package com.pablogonzalezpatarro.superheroapi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//Hacemos Hero parcelable para poder enviarlo en la navegación.
@Parcelize
data class Hero(
    val id: Int?,
    val nombre:String?,
    val genero:String?,
    val imagen:String? ):Parcelable{}
