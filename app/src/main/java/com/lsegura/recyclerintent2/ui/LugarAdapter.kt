package com.lsegura.recyclerintent2.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lsegura.recyclerintent2.R
import com.lsegura.recyclerintent2.databinding.LugarViewBinding
import com.lsegura.recyclerintent2.model.Lugar

class LugarAdapter(val lugares: List<Lugar>, val listener: (Lugar) ->Unit) :
    RecyclerView.Adapter<LugarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lugar_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lugares.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lugar = lugares[position]
        holder.bind(lugar)
        holder.itemView.setOnClickListener { listener(lugar) }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = LugarViewBinding.bind(view)
        fun bind(lugar: Lugar) {
            binding.nombre.text = lugar.nombre
            Glide.with(binding.url).load(lugar.urlImagen).into(binding.url)
        }
    }

}