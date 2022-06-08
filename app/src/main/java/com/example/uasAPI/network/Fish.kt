package com.example.uasAPI.network

import com.squareup.moshi.Json


data class Fish(
    val data: List<Data>
) {
    data class Data(
        @Json(name = "name")
        val name: String,
        @Json(name = "birth_year")
        val birth_year: String,
        @Json(name = "death_year")
        val death_year: String,
        @Json(name = "description")
        val description: String
    )
}
