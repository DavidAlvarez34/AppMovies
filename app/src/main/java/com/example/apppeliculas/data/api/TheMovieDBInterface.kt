package com.example.apppeliculas.data.api

import com.example.apppeliculas.data.vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBInterface {
    //https://api.themoviedb.org/3/movie/popular?api_key=24ef3b5f40a1912808565b8a7be0188e&language=en-US&page=1
    //https://api.themoviedb.org/3/movie/414906?api_key=24ef3b5f40a1912808565b8a7be0188e&language=en-US
    //https://api.themoviedbf.org/3/

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id")id:Int): Single<MovieDetails>

}