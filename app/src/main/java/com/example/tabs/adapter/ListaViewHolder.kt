package com.example.tabs.adapter

import android.graphics.Color
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tabs.R
import com.example.tabs.models.Personaje
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ListaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val context = view.context
    val tvItemNombre: TextView = view.findViewById(R.id.tvItemNombre)
    val tvItemDescripcion: TextView = view.findViewById(R.id.tvItemDescripcion)
    val ivItemFoto: ImageView = view.findViewById(R.id.ivItemFoto)
    val cgTipo: ChipGroup = view.findViewById(R.id.cgTipo)

    fun render(personaje: Personaje) {
        tvItemNombre.text = personaje.nombre
        tvItemDescripcion.text = personaje.descripcion

        cgTipo.removeAllViews()

        if (personaje.principal == 1) {
            generateChip(context.getString(R.string.consultar_principal), R.color.black)
        }
        if (personaje.secundario == 1) {
            generateChip(context.getString(R.string.consultar_secundario), R.color.white)
        }
        if (personaje.extra == 1){
            generateChip("Extra", R.color.Gray)
        }

        ivItemFoto.setImageURI(Uri.parse(personaje.imagen))
    }

    private fun generateChip(text: String, colorResId: Int) {
        val chip = Chip(cgTipo.context)
        chip.text = text

        chip.setChipBackgroundColorResource(colorResId)

        chip.setTextColor(Color.RED)

        cgTipo.addView(chip)
    }
}