package com.example.opendesa.ui.datadesa

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://127.0.0.1:8000"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

interface DataDesaService {
    @GET("api/data_desa")
    suspend fun getDataDesa() : List<Desa>
}

object DataDesa {
    val retrofitService: DataDesaService by lazy {
        retrofit.create(DataDesaService::class.java)
    }
}
