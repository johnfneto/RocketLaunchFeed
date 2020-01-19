package com.johnfneto.rocketlaunchfeed

import com.johnfneto.rocketlaunchfeed.models.LaunchDetailModel

interface OnDetailCallback {
    fun onSuccess(launchDetailModel: LaunchDetailModel)

    fun onError(error: String)
}