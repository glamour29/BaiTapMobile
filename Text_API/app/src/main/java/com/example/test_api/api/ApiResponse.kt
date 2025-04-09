package com.example.test_api.api

class ApiResponse<T>(
    val isSuccess: Boolean,
    val message: String,
    val data: T
)