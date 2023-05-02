package com.lordkajoc.latihankoneksitmdb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lordkajoc.latihankoneksitmdb.databinding.ItemListFilmBinding
import com.lordkajoc.latihankoneksitmdb.model.GetAllFilmResponse

class AdapterFilm(var listFilm: List<GetAllFilmResponse>) :
    RecyclerView.Adapter<AdapterFilm.ViewHolder>() {

    class ViewHolder(var binding: ItemListFilmBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemListFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitleFilm.text = listFilm[position].originalTitle
        holder.binding.tvTanggalFilm.text = listFilm[position].releaseDate
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500${listFilm[position].posterPath}")
            .into(holder.binding.imageViewFilm)

    }

    override fun getItemCount(): Int {
        return listFilm.size
    }


}