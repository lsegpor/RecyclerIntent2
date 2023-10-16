package com.lsegura.recyclerintent2.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lsegura.recyclerintent2.databinding.ActivityMainBinding
import com.lsegura.recyclerintent2.model.Lugar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recyclerView.adapter = LugarAdapter(lugares) { lugar ->

                val latLng = "${lugar.latitud},${lugar.longitud}"
                val uri = "geo:$latLng?q=${Uri.encode(lugar.nombre)}"
                val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                startActivity(mapIntent)
            }
        }

    }
}

private val lugares = (1..100).map {
    Lugar("Lugar $it",
        "https://picsum.photos/200/300?random=$it",
        "40.4165000",
        "-3.7025600")
}