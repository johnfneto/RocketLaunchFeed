package com.johnfneto.rocketlaunchfeed.models

data class LaunchModel(
    val id: String?,
    val url: String?,
    val launch_library_id: Number?,
    val slug: String?,
    val name: String?,
    var img_url: String?,
    val status: Status?,
    val net: String?,
    val window_end: String?,
    val window_start: String?,
    val inhold: Boolean?,
    val tbdtime: Boolean?,
    val tbddate: Boolean?,
    val probability: Number?,
    val holdreason: Any?,
    val failreason: Any?,
    val hashtag: Any?,
    val rocket: Rocket?,
    val mission: Mission?,
    val pad: Pad?,
    val image_url: String?,
    val infographic_url: Any?
)

data class Configuration(
    val id: Number?,
    val launch_library_id: Number?,
    val url: String?,
    val name: String?,
    val launch_service_provider: String?
)

data class Location(val id: Number?, val name: String?, val country_code: String?)

data class Mission(
    val id: Number?,
    val launch_library_id: Number?,
    val name: String?,
    val description: String?,
    val type: String?,
    val orbit: String?,
    val orbit_abbrev: String?
)

data class Rocket(
    val id: Number?,
    val configuration: Configuration?,
    val launcher_stage: List<Any>?,
    val spacecraft_stage: Any?
)

data class Status(val id: Number?, val name: String?)