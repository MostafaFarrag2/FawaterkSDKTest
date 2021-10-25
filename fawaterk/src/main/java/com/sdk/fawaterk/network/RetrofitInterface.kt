package com.sdk.fawaterk.network
import retrofit2.Call
import retrofit2.http.*

import com.google.gson.JsonElement

import com.sdk.fawaterk.model.InvoiceModel
import com.sdk.fawaterk.model.InvoiceResponseModel

interface RetrofitInterface {
    @POST(ApiFactory.API_INVOICES_CREATE)
    fun createInvoice(@Header("Authorization") token: String,
                      @Header("Accept-InvoiceLanguage") lang: String,
                      @Header("Content-Type") contentType: String,
                      @Body body: InvoiceModel
    ): Call<InvoiceResponseModel>

}