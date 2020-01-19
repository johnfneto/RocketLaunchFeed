package com.johnfneto.rocketlaunchfeed.models

data class LaunchDetailModel(
    val id: String?,
    val url: String?,
    val launch_library_id: Number?,
    val slug: String?,
    val name: String?,
    val img_url: Any?,
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
    val rocket: Rocket_dt?,
    val mission: Any?,
    val pad: Pad?,
    val infoURLs: List<Any>?,
    val vidURLs: List<Any>?,
    val image_url: String?,
    val infographic_url: Any?
)

data class Configuration_dt(
    val id: Number?,
    val launch_library_id: Number?,
    val url: String?,
    val name: String?,
    val description: String?,
    val family: String?,
    val full_name: String?,
    val launch_service_provider: Launch_service_provider?,
    val variant: String?,
    val alias: String?,
    val min_stage: Number?,
    val max_stage: Number?,
    val length: Number?,
    val diameter: Number?,
    val maiden_flight: String?,
    val launch_mass: Number?,
    val leo_capacity: Number?,
    val gto_capacity: Any?,
    val to_thrust: Any?,
    val apogee: Any?,
    val vehicle_range: Any?,
    val image_url: String?,
    val info_url: Any?,
    val wiki_url: String?
)

data class Launch_service_provider(
    val id: Number?,
    val url: String?,
    val name: String?,
    val featured: Boolean?,
    val type: String?,
    val country_code: String?,
    val abbrev: String?,
    val description: Any?,
    val administrator: Any?,
    val founding_year: Any?,
    val launchers: String?,
    val spacecraft: String?,
    val launch_library_url: String?,
    val successful_launches: Number?,
    val failed_launches: Number?,
    val pending_launches: Number?,
    val info_url: String?,
    val wiki_url: String?,
    val logo_url: Any?,
    val image_url: Any?,
    val nation_url: Any?
)

data class Pad(
    val id: Number?,
    val agency_id: Any?,
    val name: String?,
    val info_url: Any?,
    val wiki_url: String?,
    val map_url: String?,
    val latitude: String?,
    val longitude: String?,
    val location: Location?
)

data class Rocket_dt(
    val configuration: Configuration_dt?,
    val launcher_stage: List<Any>?,
    val spacecraft_stage: Any?
)



