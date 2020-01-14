package com.johnfneto.rocketlaunchfeed.services

import androidx.lifecycle.MutableLiveData
import com.johnfneto.rocketlaunchfeed.OnDataCallback
import com.johnfneto.rocketlaunchfeed.models.ResultsModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LaunchRepository {
    private val launchApi: LaunchApi = Service().createService(LaunchApi::class.java)

    fun getLaunches(callBack: OnDataCallback ) {

        launchApi.getLaunchesList("json").enqueue(object : Callback<ResultsModel> {

            override fun onResponse(call: Call<ResultsModel>, response: Response<ResultsModel>) {
                if (response.isSuccessful) {
                    callBack.onSuccess(response.body()!!)
                } else {
                    callBack.onError("")
                }
            }

            override fun onFailure(call: Call<ResultsModel>, t: Throwable) {
                callBack.onError(t.message!!)
            }
        })

    }
}