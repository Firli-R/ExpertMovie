package com.example.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.core.R
import com.example.core.databinding.ListItemBinding
import com.example.core.domain.model.EntityItem



class ListAdapter : RecyclerView.Adapter<ListAdapter.MovieViewHolder>(){
    private var listMovie = ArrayList<EntityItem>()

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    fun setData(data: List<EntityItem>){
        if (data == null) return
        listMovie.clear()
        listMovie.addAll(data)
    }
    fun clearData(){
        listMovie.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val listItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    inner class MovieViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: EntityItem){
            with(binding){
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/original${entity.posterPath}")
                    .placeholder(R.drawable.ic_movie)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .fitCenter()
                    .into(ivUser)
                tvName.text = entity.title
                tvYear.text = entity.releaseDate
                rateText.text = entity.rating.toString()

                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(entity)
                }
            }
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: EntityItem)
    }


}