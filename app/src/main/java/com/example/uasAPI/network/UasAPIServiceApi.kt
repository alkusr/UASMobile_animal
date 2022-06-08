package com.example.uasAPI.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://indonesia-public-static-api.vercel.app/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UasAPIServiceApi {
    @GET("heroes")
    suspend fun getFish(): Fish

    @GET("volcanoes")
    suspend fun getSea(): Sea

    @GET("publishers")
    suspend fun getBugs(): Bugs
}

object UasAPIApi {
    val retrofitServiceApi: UasAPIServiceApi by lazy {
        retrofit.create(UasAPIServiceApi::class.java)
    }
}