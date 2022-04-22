package com.example.geoform.entity

data class ValidationResult(
    var isError: Boolean = false,
    var errorMessage: String = ""
)
