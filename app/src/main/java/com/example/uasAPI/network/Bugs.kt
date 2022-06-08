package com.example.uasAPI.network

import com.squareup.moshi.Json

data class Bugs(
    val data: List<Data>
) {
    data class Data(
        @Json(name = "penerbit")
        val penerbit: String,
        @Json(name = "no_anggota")
        val no_anggota: String,
        @Json(name = "wilayah")
        val wilayah: String,
        @Json(name = "tahun_masuk")
        val tahun_masuk: String
    )
}