package com.murat.retrofitcoroutine.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murat.retrofitcoroutine.models.TvShowItem
import com.murat.retrofitcoroutine.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
    @Inject
    constructor
    (private val repository: TvShowRepository):ViewModel() {

         val _response : MutableLiveData<List<TvShowItem>> by lazy {
             MutableLiveData<List<TvShowItem>>()
         }
   /* val responseTvShow : LiveData<List<TvShowItem>>
    get() = _response*/

    init {
        getAllTVShows()
    }

    private fun getAllTVShows()  = viewModelScope.launch {
        repository.getTvShows().let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("resp","getAllTVShows${response.code()}")
            }

        }
    }
}