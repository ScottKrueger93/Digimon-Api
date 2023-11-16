package com.syntax_institut.android_ta_apiwdh.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.syntax_institut.android_ta_apiwdh.data.model.DigimonResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://digimon-api.com/api/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DigimonApiService {
    @GET("digimon")
    suspend fun getDigimon(): DigimonResult

    @GET("digimon/{id}")
    suspend fun getDigimonExample(@Path("id") id: Int): DigimonResult {
        return DigimonApi.retrofitService.getDigimonExample(id)
    }
}

object DigimonApi {
    val retrofitService: DigimonApiService by lazy { retrofit.create(DigimonApiService::class.java) }
}