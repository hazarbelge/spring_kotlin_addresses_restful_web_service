package com.hazarbelge.addresses.model

data class ResponseModel<T>(
    val is_success: Boolean = false,
    val message: String = "",
    val http_code: Int = 500,
    val data: T,
)
