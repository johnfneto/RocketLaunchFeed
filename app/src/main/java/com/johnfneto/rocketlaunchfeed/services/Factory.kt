package com.johnfneto.rocketlaunchfeed.services

import androidx.lifecycle.MutableLiveData
import com.johnfneto.rocketlaunchfeed.models.ResultsModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Factory {
    private val launchApi: LaunchApi = Service().createService(LaunchApi::class.java)

    fun getLaunches(): MutableLiveData<ResultsModel> {
        val resultsModel = MutableLiveData<ResultsModel>()

        launchApi.getLaunchesList("json").enqueue(object : Callback<ResultsModel> {

            override fun onResponse(call: Call<ResultsModel>, response: Response<ResultsModel>) {
                if (response.isSuccessful) {
                    resultsModel.value = response.body()
                }
            }

            override fun onFailure(call: Call<ResultsModel>, t: Throwable) {
                resultsModel.value = null
            }
        })
        return resultsModel
    }
}