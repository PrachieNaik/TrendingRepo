package com.example.trendingrepo.network

import com.example.trendingrepo.data.TrendingRepoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TrendingRepoApi {

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("search/repositories?sort=stars")
    fun getTrendingRepo(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ) : Call<TrendingRepoResponse>

}