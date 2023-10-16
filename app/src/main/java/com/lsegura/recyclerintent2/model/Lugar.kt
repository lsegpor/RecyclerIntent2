package com.lsegura.recyclerintent2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Lugar (
    val nombre: String,
    val urlImagen: String,
    val latitud: String,
    val longitud: String
): Parcelable