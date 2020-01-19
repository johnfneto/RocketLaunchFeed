package com.johnfneto.rocketlaunchfeed.models

data class ResultsModel(
    val count: Number?,
    val next: String?,
    val previous: String?,
    val results: List<LaunchModel>
)