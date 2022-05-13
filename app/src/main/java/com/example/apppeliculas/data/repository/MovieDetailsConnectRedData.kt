package com.example.apppeliculas.data.repository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apppeliculas.data.api.TheMovieDBInterface
import com.example.apppeliculas.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieDetailsConnectRedData (private val apiService: TheMovieDBInterface, private val compositeDisposable: CompositeDisposable) {
    private val _networkState = MutableLiveData<NetworkState>()
    val myNetworkState:LiveData<NetworkState>
    get() = _networkState

    private val _downloadedMovieDetailsRes = MutableLiveData<MovieDetails>()
    val downloadedMovieResult: LiveData<MovieDetails>
    get() = _downloadedMovieDetailsRes

    fun fetchMovieDetails(movieId: Int){
        _networkState.postValue(NetworkState.LOADING)
        try {
            compositeDisposable.add(
                apiService.getMovieDetails(movieId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedMovieDetailsRes.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("Movie details ",it.message.toString())
                        }
                    )
            )
        }
        catch(e: Exception){
            Log.e("Movie Details Data", e.message.toString())
        }
    }
}