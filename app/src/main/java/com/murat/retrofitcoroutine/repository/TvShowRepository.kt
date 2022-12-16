package com.murat.retrofitcoroutine.repository

import com.murat.retrofitcoroutine.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject
constructor(private val apiService: ApiService ){
    suspend fun getTvShows() = apiService.getVvShow()


}