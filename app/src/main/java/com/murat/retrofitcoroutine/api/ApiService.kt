package com.murat.retrofitcoroutine.api

import com.murat.retrofitcoroutine.helper.Constants
import com.murat.retrofitcoroutine.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getVvShow():Response<TvShowResponse>
}