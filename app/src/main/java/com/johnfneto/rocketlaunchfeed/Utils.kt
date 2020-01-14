package com.johnfneto.rocketlaunchfeed

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    @JvmStatic
    fun formatDate(date: String): String {

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        return try {
            SimpleDateFormat("dd MMM yyyy 'at' HH:mm", Locale.ENGLISH).format(inputFormat.parse(date)!!)
        } catch (e: ParseException) {
            ""
        }
    }

    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        networkCapabilities.apply {
            return when {
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }

    }
}