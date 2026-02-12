package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.ui.state.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()

    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    fun getWeather(city: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

            try {
                val weather = repository.getWeather(city)
                _uiState.value = WeatherUiState(
                    isLoading = false,
                    weatherData = weather,
                    errorMessage = null
                )
            } catch (e: Exception) {
                _uiState.value = WeatherUiState(
                    isLoading = false,
                    weatherData = null,
                    errorMessage = "Failed to load weather data"
                )
            }
        }
    }
}
