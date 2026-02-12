package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.remote.RetrofitInstance

class WeatherRepository {
    private val api = RetrofitInstance.api
    private val apiKey = "cb47268dccab4a01800173841261202" // Your WeatherAPI.com API key

    suspend fun getWeather(city: String): WeatherResponse {
        return api.getWeather(apiKey, city)
    }
}
