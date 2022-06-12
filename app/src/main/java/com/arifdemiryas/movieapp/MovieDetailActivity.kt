package com.arifdemiryas.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        val title = intent.getStringExtra("title")
        val imdb = intent.getStringExtra("imdb")
        val overview = intent.getStringExtra("overview")
        val image = intent.getStringExtra("image")

        Glide.with(this).load(IMAGE_BASE + image).into(detail_image)
        detail_title.text = " " +title
        detail_imdb.text = " IMDB : "+ imdb
        detail_overview.text = " Overview : " + overview

    }
}