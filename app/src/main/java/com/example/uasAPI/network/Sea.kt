package com.example.uasAPI.network


import com.squareup.moshi.Json

data class Sea(
    val data: List<Data>
) {
    data class Data(
        @Json(name = "nama")
        val nama: String,
        @Json(name = "bentuk")
        val bentuk: String,
        @Json(name = "tinggi_meter")
        val tinggi_meter: String,
        @Json(name = "estimasi_letusan_terakhir")
        val estimasi_letusan_terakhir: String,
        @Json(name = "geolokasi")
        val geolokasi: String
    )
}