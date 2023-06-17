package com.example.maid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maid.R
import com.example.maid.data.UpcomingData

class UpcomingAdapter(
    private val context: Context,
    private val music: List<UpcomingData>,
    val listener: (UpcomingData) -> Unit
) : RecyclerView.Adapter<UpcomingAdapter.AnimeViewHolder>() {

    inner class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgMusic: ImageView = view.findViewById(R.id.image_harga)
        val nameMusic: TextView = view.findViewById(R.id.nama_harga)

        fun bindView(music: UpcomingData, listener: (UpcomingData) -> Unit) {
            imgMusic.setImageResource(music.imgharga)
            nameMusic.text = music.nameharga
            itemView.setOnClickListener {
                listener(music)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_upcoming, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bindView(music[position], listener)
    }

    override fun getItemCount(): Int = music.size
}
