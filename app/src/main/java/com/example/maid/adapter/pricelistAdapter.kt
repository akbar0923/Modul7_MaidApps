package com.example.maid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maid.R
import com.example.maid.data.pricelist

class pricelistAdapter(
    private val context: Context,
    private val music: List<pricelist>,
    val listener: (pricelist) -> Unit
) : RecyclerView.Adapter<pricelistAdapter.AnimeViewHolder>() {
    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgmusic = view.findViewById<ImageView>(R.id.image_pricelist)
        val namemusic = view.findViewById<TextView>(R.id.nama_price)

        fun bindView(music: pricelist, listener: (pricelist) -> Unit) {
            imgmusic.setImageResource(music.imgpricelist)
            namemusic.text = music.namepricelist
            itemView.setOnClickListener {
                (listener(music))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bindView(music[position], listener)
    }

    override fun getItemCount(): Int = music.size

}
