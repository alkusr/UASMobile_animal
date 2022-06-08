package com.example.uasAPI.network

import com.squareup.moshi.Json


data class Fish(
    val data: List<Data>
) {
    data class Data(
        val id: String,
        val rarity: String,
        val location: String,
        @Json(name = "file-name")
        val name: String,
        @Json(name = "museum-phrase")
        val phrase: String
    )
}
