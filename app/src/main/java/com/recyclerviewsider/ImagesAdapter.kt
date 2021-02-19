package com.recyclerviewsider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.recyclerviewsider.databinding.ItemBinding

class ImagesAdapter(private var images : ArrayList<String>) : RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImagesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        Glide.with(holder.binding.root)
            .load(images[position])
            .into(holder.binding.ivImages)
    }

    class ImagesViewHolder(val binding: ItemBinding) :RecyclerView.ViewHolder(binding.root)
}