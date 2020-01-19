package com.johnfneto.rocketlaunchfeed.services

import com.johnfneto.rocketlaunchfeed.models.LaunchDetailModel
import com.johnfneto.rocketlaunchfeed.models.ResultsModel
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LaunchApi {

    @GET("launch/upcoming/")
    fun getLaunchesList(@Query("format") format: String): Call<ResultsModel>

    @GET("launch/{id}/")
    fun getLaunchDetail(@Path("id") id: String, @Query("format") format: String): Call<LaunchDetailModel>
}