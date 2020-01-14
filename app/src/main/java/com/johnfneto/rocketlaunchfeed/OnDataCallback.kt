package com.johnfneto.rocketlaunchfeed

import com.johnfneto.rocketlaunchfeed.models.ResultsModel

interface OnDataCallback {
    fun onSuccess(resultsModel: ResultsModel)

    fun onError(error: String)
}