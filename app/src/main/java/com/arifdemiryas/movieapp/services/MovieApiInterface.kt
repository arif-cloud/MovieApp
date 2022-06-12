package com.arifdemiryas.movieapp.services

import com.arifdemiryas.movieapp.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import android.telecom.Call as Call1

interface MovieApiInterface {

    @GET ("/3/movie/popular?api_key=e2674c6dbf0068e5708c6de0840f858d")
    fun getMovieList(): Call<MovieResponse>
}