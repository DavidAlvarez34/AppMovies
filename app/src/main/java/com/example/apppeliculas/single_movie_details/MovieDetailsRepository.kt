package com.example.apppeliculas.single_movie_details
import android.net.Network
import androidx.lifecycle.LiveData
import com.example.apppeliculas.data.api.TheMovieDBInterface
import com.example.apppeliculas.data.repository.MovieDetailsConnectRedData
import com.example.apppeliculas.data.repository.NetworkState
import com.example.apppeliculas.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable


class MovieDetailsRepository (private val apiService: TheMovieDBInterface) {
    lateinit var movieDetailsConnectRedData: MovieDetailsConnectRedData
    fun movieDetails(compositeDisposable: CompositeDisposable, movieId: Int):LiveData<MovieDetails>{
        movieDetailsConnectRedData= MovieDetailsConnectRedData(apiService,compositeDisposable)
        return movieDetailsConnectRedData.downloadedMovieResult
    }
    fun getMovieDetailsNetworkState():LiveData<NetworkState>{
        return
    }
}