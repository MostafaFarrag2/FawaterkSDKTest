package com.sdk.fawaterk
import com.google.gson.JsonElement
import com.sdk.fawaterk.model.InvoiceModel
import com.sdk.fawaterk.model.InvoiceResponseModel
import com.sdk.fawaterk.network.ApiFactory
import com.sdk.fawaterk.utils.Const
import retrofit2.Call
import retrofit2.Response
import  com.sdk.fawaterk.utils.Const.listener
class FawSDKController {

    val configError = "Configuration error"
    val serverError = "Server is down, please contact the SDK developer"

    fun createInvoice(lang: String, token: String, body: InvoiceModel){
        val responseCall = ApiFactory.create().createInvoice(token, lang,
            "application/json", body)
        responseCall.enqueue(object: retrofit2.Callback<InvoiceResponseModel>{

            override fun onResponse(call: Call<InvoiceResponseModel>,
                                    response: Response<InvoiceResponseModel>) =
                when {
                    response.code() == Const.SUCCESS ->
                        listener.onCreateInvoiceSuccess(response.body()!!)
                    response.code() == Const.SERVER_ERROR ->
                        listener.onCreateInvoiceFailed(response.code(), serverError)
                    else ->
                        listener.onCreateInvoiceFailed(response.code(), response.errorBody()!!.string())
                }

            override fun onFailure(call: Call<InvoiceResponseModel>?, t: Throwable?) {
                listener.onCreateInvoiceFailed(Const.CONFIG_ERROR, configError)
            }
        })
    }
}