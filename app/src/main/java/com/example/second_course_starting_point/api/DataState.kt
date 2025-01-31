package com.example.second_course_starting_point.api

sealed class DataState<out T> {
    data class Success<T>(val data: T) : DataState<T>()
    data object Loading : DataState<Nothing>()
    data class Error(val error: String) : DataState<Nothing>()
    data object UnInitialised: DataState<Nothing>()
}