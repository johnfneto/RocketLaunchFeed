package com.johnfneto.rocketlaunchfeed

import androidx.lifecycle.ViewModel
import com.johnfneto.rocketlaunchfeed.models.LaunchDetailModel
import com.johnfneto.rocketlaunchfeed.models.ResultsModel
import com.johnfneto.rocketlaunchfeed.services.LaunchApi
import com.johnfneto.rocketlaunchfeed.services.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchViewModel : ViewModel() {
    private val launchApi: LaunchApi = Service().createService(LaunchApi::class.java)

    fun getLaunches(callBack: OnDataCallback) {

        launchApi.getLaunchesList("json").enqueue(object : Callback<ResultsModel> {
            override fun onResponse(
                call: Call<ResultsModel>,
                response: Response<ResultsModel>
            ) {
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

    fun getLaunchDetail(id: String, callBack: OnDetailCallback) {

        launchApi.getLaunchDetail(id, "json").enqueue(object : Callback<LaunchDetailModel> {
            override fun onResponse(
                call: Call<LaunchDetailModel>,
                response: Response<LaunchDetailModel>
            ) {
                if (response.isSuccessful) {
                    callBack.onSuccess(response.body()!!)

                } else {
                    callBack.onError("")
                }
            }

            override fun onFailure(call: Call<LaunchDetailModel>, t: Throwable) {
                callBack.onError(t.message!!)
            }
        })
    }
}
