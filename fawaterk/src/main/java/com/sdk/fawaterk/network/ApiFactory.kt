package com.sdk.fawaterk.network

import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Mahmoud on 1/30/2018.
 */
internal object ApiFactory {

    var BASE_URL = "https://app.fawaterk.com/api"


    const val API_INVOICES_CREATE = "/invoice"

    fun create(): RetrofitInterface {

//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//
        val client = OkHttpClient.Builder()
//                .addInterceptor(interceptor)
            .connectTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES).build()

        val retrofit =  Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(RetrofitInterface::class.java)
    }
}