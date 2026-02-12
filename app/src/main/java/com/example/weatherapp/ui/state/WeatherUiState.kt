package com.example.weatherapp.ui.state

import com.example.weatherapp.data.model.WeatherResponse

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weatherData: WeatherResponse? = null,
    val errorMessage: String? = null
)
