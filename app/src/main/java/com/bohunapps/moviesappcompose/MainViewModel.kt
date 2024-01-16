package com.bohunapps.moviesappcompose

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bohunapps.moviesappcompose.data.models.Movie
import com.bohunapps.moviesappcompose.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {
    private val _allMovies = MutableLiveData<List<Movie>>()
    val allMovies: LiveData<List<Movie>>
        get()= _allMovies

    fun getAllMovies() {
        viewModelScope.launch {
            repository.getAllMovies().let{
                if(it.isSuccessful){
                    _allMovies.postValue(it.body())
                }else{
                    Log.e("checkData", "Failde to load movies: ${it.errorBody()}")
                }
            }
        }
    }
}