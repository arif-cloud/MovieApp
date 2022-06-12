package com.arifdemiryas.movieapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifdemiryas.movieapp.models.Movie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val movies : List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie : Movie) {
            itemView.movie_title.text = movie.title
            itemView.movie_release_date.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,MovieDetailActivity::class.java).apply {
                putExtra("title",movies.get(position).title)
                putExtra("imdb",movies.get(position).imdb.toString())
                putExtra("overview",movies.get(position).overview)
                putExtra("image",movies.get(position).poster)
            }
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = movies.size
}