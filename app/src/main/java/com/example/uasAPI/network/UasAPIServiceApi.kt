package com.example.uasAPI.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://acnhapi.com/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DoaHarianServiceApi {
    @GET("fish")
    suspend fun getFish(): Fish

    @GET("sea")
    suspend fun getSea(): Sea

    @GET("bugs")
    suspend fun getBugs(): Bugs
}

object UasAPIApi {
    val retrofitServiceApi: DoaHarianServiceApi by lazy {
        retrofit.create(DoaHarianServiceApi::class.java)
    }
}